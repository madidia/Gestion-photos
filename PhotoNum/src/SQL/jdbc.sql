-- jdbc ######## Un client ne peut avoir un code promo que si sa commande dépasse 100 euros (5) ########
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

--OK mais à gerer en jdbc################# Supprimer code déja utiliser (6) #######
Create or replace Trigger SupprimeCode
After INSERT ON commande
For each row
Declare nb integer;
BEGIN
Select count(*) into nb from Commande where code IS not NULL;
IF (nb >0) then delete from CodePersonnel where CodePersonnel.codeCP=:new.code;
end if;
END;
/
