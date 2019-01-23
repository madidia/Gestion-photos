--######## Suppresion des fichiers images non utilisés apres 10 jours ########
CREATE TRIGGER SuppFichier
After insert or update on Img
BEGIN
select 


DELETE from Img
WHERE sysdate >= (:old.dateUtilisation + 10);
raise_application_error (-20101, 'fichier supprimé!!! Derniere date utilisation depasse 10 jours');   
END;
/

--Ok####### Un client ne peut utiliser des fichiers partagés que s’il partage des fichiers (2) #######
Create or replace TRIGGER PartagerFichier
After insert or update on UtiliseImage
Declare 
nb integer;
BEGIN
select count(*) into nb from (
	select mail, count(*) from UtiliseImage natural join Img where partagee='non'
	    group by (mail) );
    if (nb > 0) then raise_application_error(-20001,'Veuillez partager des images afin de 
     	pouvoir utiliser des images d un autre utilisateur!!!');
    end if;
end;
/

--OK################ On ne peut pas imprimer si le stock est insuffisant par rapport à la quantité qu’on veut imprimer (4) ######
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

--######## Commande ne peut pas etre modifiée si le statut passe en cours########
Create TRIGGER ModificationImpossible
BEFORE insert or update or delete on Commande
DECLARE
etat varchar2(245);
BEGIN 
select statut into etat from Commande;
if (etat) in ('en cours', 'pret a lenvoi', 'envoyee') then
raise_application_error(-20101, 'Modification impossible!');
END IF;
END;
/

-- jdbc ######## Un client ne peut avoir un code promo que si sa commande dépasse 100 euros ########
Create TRIGGER CodePerso
After insert or update on Commande
DECLARE
nb integer;
BEGIN
select count(*) into nb,mail from Commande where montant > 100;
    if (nb>0) then ( insert into Code values );
    end if;
end;
/


--OK################# Les commandes seront conservées après suppression (8) #######
Create or replace TRIGGER ConserverCommande
AFTER DELETE ON Commande
For each row
BEGIN 
insert into Historique 
values (:old.numCommande,:old.mail,:old.dateComm,:old.idAdresse,:old.statut,:old.montant,:old.code);
END;
/

--OK################# Supprimer code déja utiliser (10) #######
Create or replace Trigger SupprimeCode
AFTER INSERT ON commande
For each row
Declare moncode varchar2(10);
BEGIN
Select code into moncode from Commande where code IS not NULL;
IF (moncode is not NULL) then delete from Code where Code.code=moncode;
end if;
END;
/
