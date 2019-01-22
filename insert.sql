insert into utilisateur values ('pellel.dian@gmail.com');
insert into utilisateur values ('bodiangas@gmail.com');
insert into utilisateur values ('jouhariali@gmail.com');
insert into utilisateur values ('diallothierno@gmail.com');
INSERT INTO utilisateur VALUES('ali@live.fr');
INSERT INTO utilisateur VALUES('dian@live.fr');
INSERT INTO utilisateur VALUES('ibrahima@live.fr');


INSERT INTO CLIENTP VALUES('ali@live.fr','jouhari','ali','a2a2a2');
INSERT INTO CLIENTP VALUES('dian@live.fr','Diallo','Dian','b2b2b2');
INSERT INTO CLIENTP VALUES('Ibrahima@live.fr','Diallo','Ibrahima','c2c2c2');
insert into CLIENTP values ('pellel.dian@gmail.com', 'Diallo','Mamadou Dian','123456789');
insert into CLIENTP values ('bodiangas@gmail.com', 'Bodiang','Assane','45871259');
insert into CLIENTP values ('jouhariali@gmail.com', 'Jouari','Ali','01548725');
insert into CLIENTP values ('diallothierno@gmail.com', 'Diallo','Thierno','56478259');

insert into ADRESSEC values ('6 bis rue du vieux temple 38000 Grenoble', 'pellel.dian@gmail.com');
insert into ADRESSEC values ('1220 rue des residences 38400 Saint Martin Dheres', 'pellel.dian@gmail.com');
insert into ADRESSEC values ('2 rue jules ferry 38100 Grenoble', 'bodiangas@gmail.com');
insert into ADRESSEC values ('5 rue Lieutnant Chabal 38100 Grenoble', 'bodiangas@gmail.com');
insert into ADRESSEC values ('1 rue Marcel Pagnol 38400 Saint Martin Dheres', 'jouhariali@gmail.com');
insert into ADRESSEC values ('107 rue des tailles 38400 Saint Martin Dheres','diallothierno@gmail.com');
INSERT INTO ADRESSEC VALUES('aaa bbb ccc','ali@live.fr');
INSERT INTO ADRESSEC VALUES('hhh lll ppp','dian@live.fr');
INSERT INTO ADRESSEC VALUES('ddd zzz ttt','Ibrahima@live.fr');
INSERT INTO ADRESSEC VALUES('ppp mmm lll','Ibrahima@live.fr');

insert into Code values ('VIP2019','20');
insert into Code values ('CVP2019','20');
insert into Code values ('FDP2019','20');
insert into Code values ('BBC2019','20');
insert into Code values ('BBW2019','20');

insert into CodeMarketing values ('VIP2019', '20');
insert into CodeMarketing values ('CVP2019','20');
insert into CodeMarketing values ('FDP2019','20');
insert into CodeMarketing values ('BBC2019','20');
insert into CodeMarketing values ('BBW2019','20');

insert into ARTICLE values ('124501','5000','5.00');
insert into ARTICLE values ('145278','2500','7.50');
insert into ARTICLE values ('145255','3500','7.50');
insert into ARTICLE values ('124511','5000','5.00');
insert into ARTICLE values ('145288','2500','7.50');
insert into ARTICLE values ('145275','3500','7.50');
insert into ARTICLE values ('145205','3500','7.50');

INSERT INTO Article VALUES('a200','4000','4.50');
INSERT INTO Article VALUES('a100','750','1.50');
INSERT INTO Article VALUES('a300','950','2.50');
INSERT INTO Article VALUES('a400','730','3.50');

insert into COMMANDE values ('06012019MN12', 'pellel.dian@gmail.com','06-JAN-19','6 bis rue du vieux temple 38000 Grenoble','en cours','12.0',NULL,'124501','15');
insert into COMMANDE values ('05012019MN11', 'bodiangas@gmail.com','05-JAN-19','5 rue Lieutnant Chabal 38100 Grenoble','envoyee','25.0',NULL,'124501','30');
insert into COMMANDE values ('05012019MN12', 'jouhariali@gmail.com','05-JAN-19','1 rue Marcel Pagnol 38400 Saint Martin Dheres','envoyee','35.0','VIP2019','145278','25');
insert into COMMANDE values ('05012019MN13', 'diallothierno@gmail.com','05-JAN-19','107 rue des tailles 38400 Saint Martin Dheres','pret a l envoi','45.0','VIP2019','145278','43');

insert into HISTORIQUE values ('06012019MN12', 'pellel.dian@gmail.com','06-JAN-19','6 bis rue du vieux temple 38000 Grenoble','en cours','12.0',NULL,'124501','15');
insert into HISTORIQUE values ('05012019MN11', 'bodiangas@gmail.com','05-JAN-19','5 rue Lieutnant Chabal 38100 Grenoble','envoyee','25.0',NULL,'124501','30');
insert into HISTORIQUE values ('05012019MN12', 'jouhariali@gmail.com','05-JAN-19','1 rue Marcel Pagnol 38400 Saint Martin Dheres','envoyee','35.0','VIP2019','145278','25');
insert into HISTORIQUE values ('05012019MN13', 'diallothierno@gmail.com','05-JAN-19','107 rue des tailles 38400 Saint Martin Dheres','pret a l envoi','45.0','VIP2019','145278','43');

/* rajouter idcommande dans impression ? */

insert into IMPRESSION values ('125425','haute precision','124501','pellel.dian@gmail.com');
insert into IMPRESSION values ('125435','haute precision','145278','bodiangas@gmail.com');
insert into IMPRESSION values ('128535','moyenne','145255','diallothierno@gmail.com');
insert into IMPRESSION values ('118535','moyenne','124511','jouhariali@gmail.com');


INSERT INTO Img VALUES('/pp/ll.png','ali@live.fr','650x480','oui','11-JAN-19');
INSERT INTO Img VALUES('/yy/aa.png','ali@live.fr','400x500','oui','09-JAN-19');
INSERT INTO Img VALUES('/jj/bb.png','ibrahima@live.fr','550x700','non','05-DEC-18');
INSERT INTO Img VALUES('/ad/cc.png','dian@live.fr','150x220','non','08-JAN-19');
INSERT INTO Img VALUES('/sr/dd.png','dian@live.fr','650x480','oui','07-OCT-19');

INSERT INTO Photo VALUES('p121','/pp/ll.png','500','ppppp');
INSERT INTO Photo VALUES('p230','/yy/aa.png','1024','dddd');
INSERT INTO Photo VALUES('p430','/yy/aa.png','800','aaaa');
INSERT INTO Photo VALUES('p300','/jj/bb.png','800','bbbb');
INSERT INTO Photo VALUES('p860','/ad/cc.png','1376','jjjj');
INSERT INTO Photo VALUES('p110','/sr/dd.png','1024','oooo');


INSERT INTO Tirage VALUES('125425','haute qualite');
INSERT INTO Tirage VALUES('125435','haute qualite');


INSERT INTO Album VALUES('118535','p121','mon album photo','15x10');
INSERT INTO Album VALUES('128535','p430','album 2018','25x14');


/*INSERT INTO Cadre VALUES('imp3','format3','low');
INSERT INTO Cadre VALUES('imp4','format3','low');
INSERT INTO TiragePhoto VALUES('imp2','p121');
INSERT INTO TiragePhoto VALUES('imp2','p230');   
INSERT INTO CadrePhoto VALUES('imp4','p230');
INSERT INTO PagePhoto VALUES('imp1','p300');
INSERT INTO PagePhoto VALUES('imp1','p860');
INSERT INTO Page VALUES('1','imp1','p300');
INSERT INTO Page VALUES('2','imp1','p860');
*/




