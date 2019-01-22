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


insert into ADRESSEC values ('6 bis rue du vieux temple 38000 Grenoble', 'sgidney0@typepad.com');
insert into ADRESSEC values ('1220 rue des residences 38400 Saint Martin Dheres', 'sbarlthrop1@netscape.com');
insert into ADRESSEC values ('2 rue jules ferry 38100 Grenoble', 'rwellsman2@google.com.au');
insert into ADRESSEC values ('5 rue Lieutnant Chabal 38100 Grenoble', 'bsheards3@ezinearticles.com');
insert into ADRESSEC values ('1 rue Marcel Pagnol 38400 Saint Martin Dheres', 'cfernanando4@newsvine.com');
insert into ADRESSEC values ('107 rue des tailles 38400 Saint Martin Dheres','hvasichev5@jiathis.com');
INSERT INTO ADRESSEC VALUES('108 rue des tailles 38400 Saint Martin Dheres','rgoshawk6@unicef.org');
INSERT INTO ADRESSEC VALUES('8 rue jules ferry 38100 Grenoble','lickovic7@ihg.com');
INSERT INTO ADRESSEC VALUES('5 rue Lieutnant Chabal 38100 Grenoble','aeastgate8@google.co.uk');


insert into Commande (numCommande, mail, dateComm, adresseLivraison, statut, montant) values (1, 'sgidney0@typepad.com', '11-JAN-19', '6 bis rue du vieux temple 38000 Grenoble', 'en cours', 3.4);
insert into Commande (numCommande, mail, dateComm, adresseLivraison, statut, montant) values (2, 'sbarlthrop1@netscape.com', '08-DEC-18', '1220 rue des residences 38400 Saint Martin Dheres', 'en cours', 134.0);
insert into Commande (numCommande, mail, dateComm, adresseLivraison, statut, montant) values (3, 'rwellsman2@google.com.au', '09-NOV-18', '2 rue jules ferry 38100 Grenoble', 'envoyee', 53.4);
insert into Commande (numCommande, mail, dateComm, adresseLivraison, statut, montant) values (4, 'bsheards3@ezinearticles.com', '11-JAN-19', '5 rue Lieutnant Chabal 38100 Grenoble', 'en cours', 15.9);
insert into Commande (numCommande, mail, dateComm, adresseLivraison, statut, montant) values (5, 'cfernanando4@newsvine.com', '10-DEC-18', '1 rue Marcel Pagnol 38400 Saint Martin Dheres', 'pret a lenvoi', 105.3);
insert into Commande (numCommande, mail, dateComm, adresseLivraison, statut, montant) values (6, 'hvasichev5@jiathis.com', '05-DEC-18', '107 rue des tailles 38400 Saint Martin Dheres', 'pret a lenvoi', 77.2);
insert into Commande (numCommande, mail, dateComm, adresseLivraison, statut, montant) values (7, 'rgoshawk6@unicef.org', '02-OCT-18', '108 rue des tailles 38400 Saint Martin Dheres', 'pret a lenvoi', 136.8);
insert into Commande (numCommande, mail, dateComm, adresseLivraison, statut, montant) values (8, 'lickovic7@ihg.com', '11-NOV-18', '8 rue jules ferry 38100 Grenoble', 'pret a lenvoi', 137.2);
insert into Commande (numCommande, mail, dateComm, adresseLivraison, statut, montant) values (9, 'aeastgate8@google.co.uk', '10-DEC-18', '5 rue Lieutnant Chabal 38100 Grenoble', 'envoyee', 144.6);

insert into HISTORIQUE (numCommande, mail, dateComm, adresseLivraison, statut, montant) values (1, 'sgidney0@typepad.com', '11-JAN-19', '6 bis rue du vieux temple 38000 Grenoble', 'en cours', 3.4);
insert into HISTORIQUE (numCommande, mail, dateComm, adresseLivraison, statut, montant) values (2, 'sbarlthrop1@netscape.com', '08-DEC-18', '1220 rue des residences 38400 Saint Martin Dheres', 'en cours', 134.0);
insert into HISTORIQUE (numCommande, mail, dateComm, adresseLivraison, statut, montant) values (3, 'rwellsman2@google.com.au', '09-NOV-18', '2 rue jules ferry 38100 Grenoble', 'envoyee', 53.4);
insert into HISTORIQUE (numCommande, mail, dateComm, adresseLivraison, statut, montant) values (4, 'bsheards3@ezinearticles.com', '11-JAN-19', '5 rue Lieutnant Chabal 38100 Grenoble', 'en cours', 15.9);
insert into HISTORIQUE (numCommande, mail, dateComm, adresseLivraison, statut, montant) values (5, 'cfernanando4@newsvine.com', '10-DEC-18', '1 rue Marcel Pagnol 38400 Saint Martin Dheres', 'pret a lenvoi', 105.3);
insert into HISTORIQUE (numCommande, mail, dateComm, adresseLivraison, statut, montant) values (6, 'hvasichev5@jiathis.com', '05-DEC-18', '107 rue des tailles 38400 Saint Martin Dheres', 'pret a lenvoi', 77.2);
insert into HISTORIQUE (numCommande, mail, dateComm, adresseLivraison, statut, montant) values (7, 'rgoshawk6@unicef.org', '02-OCT-18', '108 rue des tailles 38400 Saint Martin Dheres', 'pret a lenvoi', 136.8);
insert into HISTORIQUE (numCommande, mail, dateComm, adresseLivraison, statut, montant) values (8, 'lickovic7@ihg.com', '11-NOV-18', '8 rue jules ferry 38100 Grenoble', 'pret a lenvoi', 137.2);
insert into HISTORIQUE (numCommande, mail, dateComm, adresseLivraison, statut, montant) values (9, 'aeastgate8@google.co.uk', '10-DEC-18', '5 rue Lieutnant Chabal 38100 Grenoble', 'envoyee', 144.6);


insert into PANIER values (1,1,2);
insert into PANIER values (2,5,1);
insert into PANIER values (3,2,8);
insert into PANIER values (4,3,2);
insert into PANIER values (5,4,1);
insert into PANIER values (6,7,2);
insert into PANIER values (7,8,1);
insert into PANIER values (8,9,2);
insert into PANIER values (9,6,1);

insert into Support (idSupport) values (1);
insert into Support (idSupport) values (2);
insert into Support (idSupport) values (3);
insert into Support (idSupport) values (4);
insert into Support (idSupport) values (5);
insert into Support (idSupport) values (6);
insert into Support (idSupport) values (7);
insert into Support (idSupport) values (8);
insert into Support (idSupport) values (9);

insert into Impression (idImpression, idSupport, format, qualite, idPanier) values (1, 1, 'Konklab', 'Toughjoyfax', 1);
insert into Impression (idImpression, idSupport, format, qualite, idPanier) values (2, 2, 'Ronstring', 'Tres-Zap', 2);
insert into Impression (idImpression, idSupport, format, qualite, idPanier) values (3, 3, 'Mat Lam Tam', 'Y-find', 3);
insert into Impression (idImpression, idSupport, format, qualite, idPanier) values (4, 4, 'Veribet', 'Subin', 4);
insert into Impression (idImpression, idSupport, format, qualite, idPanier) values (5, 5, 'Temp', 'Zaam-Dox', 5);
insert into Impression (idImpression, idSupport, format, qualite, idPanier) values (6, 6, 'Fix San', 'Trippledex', 6);
insert into Impression (idImpression, idSupport, format, qualite, idPanier) values (7, 7, 'Alphazap', 'Pannier', 7);
insert into Impression (idImpression, idSupport, format, qualite, idPanier) values (8, 8, 'Alphazap', 'Ventosanzap', 8);
insert into Impression (idImpression, idSupport, format, qualite, idPanier) values (9, 9, 'Bitchip', 'Fintone', 9);


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










