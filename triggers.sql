                --######## Suppresion des fichiers images non utilisés apres 10 jours ########
CREATE TRIGGER SuppFichierNonUtilisésApres10Jours
Before insert or update on Img
FOR EACH ROW
BEGIN
DELETE from Img
WHERE sysdate >= (:old.dateUtilisation + 10);
raise_application_error (-20101, 'fichier supprimé!!! Derniere date utilisation depasse 10 jours');   
END;
/


                --????????????  ######## Commande ne peut pas etre modifiée si le statut passe en cours########
Create TRIGGER ModificationImpossible
BEFORE insert or update or delete on Commande
DECLARE
etat varchar2(245);
BEGIN 
select statut into etat from Commande;
IF (etat) in ('en cours', 'pret a lenvoi', 'envoyee') then
raise_application_error(-20101, 'Modification impossible!');
END IF;
END;
/


--################# generer un code personnel si le montant de la commande dépasse 100€ #######
Create TRIGGER CreerCodePerso
Ater insert or update on Commande
DECLARE
	nb integer;
BEGIN 
select count(*) into nb from Commande where (:new.montant > 100);
IF (nb>0) then insert into CodePersonnel values (SUBSTRING(MD5(RAND()) FROM 1 FOR 8),'5',:new.mail);
END IF;
END;
/






