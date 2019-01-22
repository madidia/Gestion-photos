insert into Utilisateur values ('sgidney0@typepad.com');
insert into Utilisateur values ('sbarlthrop1@netscape.com');
insert into Utilisateur values ('rwellsman2@google.com.au');
insert into Utilisateur values ('bsheards3@ezinearticles.com');
insert into Utilisateur values ('cfernanando4@newsvine.com');
insert into Utilisateur values ('hvasichev5@jiathis.com');
insert into Utilisateur values ('rgoshawk6@unicef.org');
insert into Utilisateur values ('lickovic7@ihg.com');
insert into Utilisateur values ('aeastgate8@google.co.uk');
insert into Utilisateur values ('aknoble9@reddit.com');
                                

insert into CLIENTP (mailC, nomC, prenomC, mdpasseC) values ('sgidney0@typepad.com', 'Gidney', 'Shelly', 'KyoAl1D');
insert into CLIENTP (mailC, nomC, prenomC, mdpasseC) values ('sbarlthrop1@netscape.com', 'Barlthrop', 'Spense', 'jJat6HZ6SE');
insert into CLIENTP (mailC, nomC, prenomC, mdpasseC) values ('rwellsman2@google.com.au', 'Wellsman', 'Reggis', 'J7qZ51p');
insert into CLIENTP (mailC, nomC, prenomC, mdpasseC) values ('bsheards3@ezinearticles.com', 'Sheards', 'Brinna', 'HcO4lmyaA');
insert into CLIENTP (mailC, nomC, prenomC, mdpasseC) values ('cfernanando4@newsvine.com', 'Fernanando', 'Carolina', '1Vs13Se2RXV');
insert into CLIENTP (mailC, nomC, prenomC, mdpasseC) values ('hvasichev5@jiathis.com', 'Vasichev', 'Hilarius', 'xzjAukwA');
insert into CLIENTP (mailC, nomC, prenomC, mdpasseC) values ('rgoshawk6@unicef.org', 'Goshawk', 'Reeva', 'fA8r0lK0Jgal');
insert into CLIENTP (mailC, nomC, prenomC, mdpasseC) values ('lickovic7@ihg.com', 'Ickovic', 'Lorrin', 'VtjKNJJ99W');
insert into CLIENTP (mailC, nomC, prenomC, mdpasseC) values ('aeastgate8@google.co.uk', 'Eastgate', 'Arnuad', 'xrNmYklQb354');


insert into Administrateur (mailA, nomA, prenomA, mdpasseA) values ('aknoble9@reddit.com', 'Knoble', 'Aubree', 'YAkib8bs6L');


insert into ADRESSE values (1,'6 bis rue du vieux temple 38000 Grenoble', 'sgidney0@typepad.com');
insert into ADRESSE values (2,'1220 rue des residences 38400 Saint Martin Dheres', 'sbarlthrop1@netscape.com');
insert into ADRESSE values (3,'2 rue jules ferry 38100 Grenoble', 'rwellsman2@google.com.au');
insert into ADRESSE values (4,'5 rue Lieutnant Chabal 38100 Grenoble', 'bsheards3@ezinearticles.com');
insert into ADRESSE values (5,'1 rue Marcel Pagnol 38400 Saint Martin Dheres', 'cfernanando4@newsvine.com');
insert into ADRESSE values (6,'107 rue des tailles 38400 Saint Martin Dheres','hvasichev5@jiathis.com');
INSERT INTO ADRESSE VALUES(7,'108 rue des tailles 38400 Saint Martin Dheres','rgoshawk6@unicef.org');
INSERT INTO ADRESSE VALUES(8,'8 rue jules ferry 38100 Grenoble','lickovic7@ihg.com');
INSERT INTO ADRESSE VALUES(9,'5 rue Lieutnant Chabal 38100 Grenoble','aeastgate8@google.co.uk');


insert into Commande values (1, 'sgidney0@typepad.com', '11-JAN-19', 1, 'en cours', 3.4,NULL);
insert into Commande values (2, 'sbarlthrop1@netscape.com', '08-DEC-18', 2, 'en cours', 134.0,NULL);
insert into Commande  values (3, 'rwellsman2@google.com.au', '09-NOV-18', 3, 'envoyee', 53.4,NULL);
insert into Commande  values (4, 'bsheards3@ezinearticles.com', '11-JAN-19', 4, 'en cours', 15.9,NULL);
insert into Commande values (5, 'cfernanando4@newsvine.com', '10-DEC-18', 5, 'pret a lenvoi', 105.3,NULL);
insert into Commande  values (6, 'hvasichev5@jiathis.com', '05-DEC-18', 6, 'pret a lenvoi', 77.2,NULL);
insert into Commande values (7, 'rgoshawk6@unicef.org', '02-OCT-18',7, 'pret a lenvoi', 136.8,NULL);
insert into Commande values (8, 'lickovic7@ihg.com', '11-NOV-18', 8, 'pret a lenvoi', 137.2,NULL);
insert into Commande values (9, 'aeastgate8@google.co.uk', '10-DEC-18', 9, 'envoyee', 144.6,NULL);

insert into Historique values (1, 'sgidney0@typepad.com', '11-JAN-19', 1, 'en cours', 3.4,NULL);
insert into Historique values (2, 'sbarlthrop1@netscape.com', '08-DEC-18', 2, 'en cours', 134.0,NULL);
insert into Historique  values (3, 'rwellsman2@google.com.au', '09-NOV-18', 3, 'envoyee', 53.4,NULL);
insert into Historique  values (4, 'bsheards3@ezinearticles.com', '11-JAN-19', 4, 'en cours', 15.9,NULL);
insert into Historique values (5, 'cfernanando4@newsvine.com', '10-DEC-18', 5, 'pret a lenvoi', 105.3,NULL);
insert into Historique  values (6, 'hvasichev5@jiathis.com', '05-DEC-18', 6, 'pret a lenvoi', 77.2,NULL);
insert into Historique values (7, 'rgoshawk6@unicef.org', '02-OCT-18',7, 'pret a lenvoi', 136.8,NULL);
insert into Historique values (8, 'lickovic7@ihg.com', '11-NOV-18', 8, 'pret a lenvoi', 137.2,NULL);
insert into Historique values (9, 'aeastgate8@google.co.uk', '10-DEC-18', 9, 'envoyee', 144.6,NULL);


insert into Support values ('papier','A3','faible',500,1.5);
insert into Support values ('papier','A4','moyenne',500,2.0);
insert into Support values ('papier','A3','elevee',500,2.5);
insert into Support values ('agenda','A3','faible',500,1.5);
insert into Support values ('album','A3','faible',500,1.5);
insert into Support values ('cadre','A3','faible',500,1.5);
insert into Support values ('papier','A4','faible',500,1.5);


insert into Impression values (1, 'A3', 'faible', 1, 1,'A3','faible','papier');
insert into Impression values (2, 'A4', 'faible', 1, 2,'A4','faible','papier');
insert into Impression values (3, 'A3', 'faible', 1, 3,'A3','faible','agenda');
insert into Impression values (4, 'A3', 'faible', 1, 4,'A3','faible','papier');
insert into Impression values (5, 'A3', 'faible', 1, 2,'A3','faible','album');
insert into Impression values (6, 'A3', 'faible', 1, 6,'A3','faible','cadre');


INSERT INTO Img VALUES('/pp/ll.png','sgidney0@typepad.com','1','oui','11-JAN-19');
INSERT INTO Img VALUES('/yy/aa.png','sbarlthrop1@netscape.com','1','oui','09-JAN-19');
INSERT INTO Img VALUES('/jj/bb.png','rwellsman2@google.com.au','7','non','05-DEC-18');
INSERT INTO Img VALUES('/ad/cc.png','bsheards3@ezinearticles.com','4','non','08-JAN-19');
INSERT INTO Img VALUES('/sr/dd.png','cfernanando4@newsvine.com','7','oui','07-OCT-19');

INSERT INTO Photo VALUES(1,'/pp/ll.png',5,'ppppp');
INSERT INTO Photo VALUES(2,'/yy/aa.png',6,'dddd');
INSERT INTO Photo VALUES(3,'/yy/aa.png',8,'aaaa');
INSERT INTO Photo VALUES(4,'/jj/bb.png',7,'bbbb');
INSERT INTO Photo VALUES(5,'/ad/cc.png',1,'jjjj');
INSERT INTO Photo VALUES(6,'/sr/dd.png',2,'oooo');

