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

--OK : on le gre en JDBC######## Commande ne peut pas etre modifiée si elle est validée (2) ########
Create or replace TRIGGER ModificationImpossible
before update on Commande
for each row
DECLARE nb integer;
BEGIN 
	select count(*) into nb from(
		select numCommande from commande where statut!='en attente' group by numCommande);
    if (nb >0) then raise_application_error(-20101, 'Modification impossible!');
END IF;
END;
/