--Ok####### Un client ne peut utiliser des fichiers partagés que s’il partage des fichiers (1) #######
Create or replace TRIGGER PartagerFichier
Before insert or update on UtiliseImage
For each row
Declare
nb integer;
BEGIN
select count(*) into nb from (
	select mail from Img where partagee='non' and mail=:new.mail
	);
    if (nb > 0) then raise_application_error(-20001,'Veuillez partager des images afin de 
     	pouvoir utiliser des images d un autre utilisateur!!!');
    end if;
end;
/



--################ On ne peut pas imprimer si le stock est insuffisant par rapport à la quantité qu’on veut imprimer (3) ######
Create or replace Trigger ImpressionImpossible
Before insert or update on Impression
For each row
declare qte integer;
begin
select quantiteStock into qte from Support where format=:new.formatSupport and qualite=:new.qualiteSupport and 
		type=:new.typeSupport;
If (:new.nbExemplaire > qte) then raise_application_error(-20102, 'Impossible d imprimer, le stock est insuffisant');
end if;
End;
/

--OK################# Les commandes seront conservées après suppression (5) #######
Create or replace TRIGGER ConserverCommande
AFTER DELETE ON Commande
For each row
BEGIN 
insert into Historique 
values (:old.numCommande,:old.mail,:old.dateComm,:old.idAdresse,:old.statut,:old.montant,:old.code);
END;
/
