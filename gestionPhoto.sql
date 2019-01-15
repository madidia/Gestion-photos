--############################## DROP TABLE IN DATABASE #####################################
DROP TABLE AgendaPhoto;
DROP TABLE PagePhoto;
DROP TABLE CadrePhoto;
DROP TABLE TiragePhoto;
DROP TABLE Pge;
DROP TABLE Cadre;
DROP TABLE Agenda;
DROP TABLE Calendrier;
DROP TABLE Album;
DROP TABLE Tirage;
DROP TABLE Photo;
DROP TABLE Img;
DROP TABLE Impression;
DROP TABLE Historique;
DROP TABLE Commande;
DROP TABLE Article;
DROP TABLE adresseC;
DROP TABLE codePersonnel;
DROP TABLE CodeMarketing;
DROP TABLE Code;
DROP TABLE Operation;
DROP TABLE Administrateur;
DROP TABLE Client;
DROP TABLE utilisateur;


--################################ CREATION DE LA TABLE Client ###########################
create table utilisateur(mailU varchar2(245) primary key);


--################################ CREATION DE LA TABLE Client ###########################
create table Client(mailC varchar2(245) primary key,
                    nomC varchar2(245) not null,
                    prenomC varchar2(245) not null,
                    mdpasseC varchar2(245) not null,
                    constraint c_c1 foreign key(mailC) references utilisateur(mailU));

--################################ CREATION DE LA TABLE Admin ###########################
create table Administrateur(mailA varchar2(245) primary key,
                    nomA varchar2(245) not null,
                    prenomA varchar2(245) not null,
                    mdpasseC varchar2(245) not null,
                    constraint c_c1 foreign key(mailA) references utilisateur(mailU));

--################################ CREATION DE LA TABLE Operation ###########################
create table Operation(dateOp date primary key,
                        detail varchar2(245) not null,
                        mail varchar2(245) varchar2(245) not null,
                        constraint o_c1 foreign key (mail) references Administrateur(mailA));

--################################ CREATION DE LA TABLE Code ###########################
create table Code(code varchar2(245) primary key,
                    valeur integer not null);


--################################ CREATION DE LA TABLE CodeMarketing ###########################
create table CodeMarketing(codeCM varchar2(245) primary key,
                            valeurCM integer not null,
                            constraint cm_c1 foreign key (codeCM) references Code(code));

--################################ CREATION DE LA TABLE CodePersonnel ###########################
create table CodePersonnel(CodeCP varchar2(245) primary key,
                            valeurCP integer not null,
                            mailCP varchar2(245) not null,
                            constraint cp_c1 foreign key (codeCP) references Code(code),
                            constraint cp_c2 foreign key (mailCP) references Client(mailC));

--################################ CREATION DE LA TABLE adresseC ###########################
create table adresseC (adresseC varchar2(245) primary key,
                        mailAC varchar2(245) not null,
                        constraint ac_c1 foreign key(mailAC) references Client(mailC));


--################################ CREATION DE LA TABLE Article ###########################
create table Article(idArticle varchar2(245) primary key,
                        quantite integer not null,
                        prix float(5,2) not null);


--################################ CREATION DE LA TABLE Commande ###########################
create table Commande(numCommande varchar2(245) primary key,
                        mail varchar2(245) not null,
                        dateComm date not null,
                        adresseLivraison varchar2(245) not null,
                        statut varchar2(245) not null,
                        montant float(5,2) not null,
                        code varchar(245) not null,
                        idArticle varchar2(245) not null,
                        quantite integer not null,
                        constraint c_c1 foreign key(mail) references Client(mailC),
                        constraint c_c2 foreign key(code) references Code(code),
                        constraint c_c3 foreign key(idArticle) references Article(idArticle));


--################################ CREATION DE LA TABLE Historique ###########################
create table Historique(numCommande varchar2(245) primary key,
                        mail varchar2(245) not null,
                        dateComm date not null,
                        adresseLivraison varchar2(245) not null,
                        statut varchar2(245) not null,
                        montant float(5,2) not null,
                        code varchar(245) not null,
                        idArticle varchar2(245) not null,
                        quantite integer not null,
                        constraint c_c1 foreign key(mail) references Client(mailC),
                        constraint c_c2 foreign key(code) references Code(code),
                        constraint c_c3 foreign key(idArticle) references Article(idArticle));

--################################ CREATION DE LA TABLE Impression ###########################
create table Impression(idImpression varchar2(245) primary key,
                        qualite varchar2(245) not null,
                        idArticle varchar2(245) not null,
                        constraint h_c1 foreign key(idArticle) references Article(idArticle));

--################################ CREATION DE LA TABLE Image ###########################
create table Img(chemin varchar2(245) primary key,
                    mail varchar2(245) not null,
                    infosVue varchar2(245) not null,
                    partagee boolean not null,
                    dateUtilisation date,
                    constraint i_c1 foreign key (mail) references Client(mailC));

--################################ CREATION DE LA TABLE Photo ###########################
create table Photo(idPhoto varchar2(245) primary key,
                    chemin varchar2(245) not null,
                    resolution varchar2(245),
                    parametre varchar2(245),
                    constraint i_p1 foreign key (chemin) references Image(chemin));

--################################ CREATION DE LA TABLE Tirage ###########################
create table Tirage(idImpression varchar2(245) primary key,
                    ordonnancement varchar2(245),
                    format varchar2(245),
                    constraint i_t1 foreign key (idImpression) references Impression(idImpression));

--################################ CREATION DE LA TABLE Album ###########################
create table Album(idImpression varchar2(245) primary key,
                    couverture varchar2(245),
                    titre varchar2(245),
                    format varchar2(245),
                    constraint i_a1 foreign key (idImpression) references Impression(idImpression));

--################################ CREATION DE LA TABLE Calendrier ###########################
create table Calendrier(idImpression varchar2(245) primary key,
                    modele varchar2(245),
                    format varchar2(245),
                    constraint i_ca1 foreign key (idImpression) references Impression(idImpression));

--################################ CREATION DE LA TABLE Agenda ###########################
create table Agenda(idImpression varchar2(245) primary key,
                    typeAgenda varchar2(245),
                    modele varchar2(245),
                    format varchar2(245),
                    constraint i_ag1 foreign key (idImpression) references Impression(idImpression));

--################################ CREATION DE LA TABLE Cadre ###########################
create table Cadre(idImpression varchar2(245) primary key,
                    taille varchar2(245),
                    modele varchar2(245),
                    constraint i_a1 foreign key (idImpression) references Impression(idImpression));

--################################ CREATION DE LA TABLE Page ###########################
create table Pge(numPage varchar2(245) primary key,
                    idImpression varchar2(245),
                    constraint i_pag1 foreign key (idImpression) references Impression(idImpression));

--################################ CREATION DE LA TABLE TiragePhoto ###########################
create table TiragePhoto(idImpression varchar2(245),
                    idPhoto varchar2(245),
                    constraint pk_tp1 primary key (idImpression,idPhoto),
                    constraint i_tp1 foreign key (idImpression) references Impression(idImpression),
                    constraint i_tp2 foreign key (idPhoto) references Photo(idPhoto));

--################################ CREATION DE LA TABLE CadrePhoto ###########################
create table CadrePhoto(idImpression varchar2(245),
                    idPhoto varchar2(245),
                    constraint pk_cp1 primary key (idImpression,idPhoto),
                    constraint i_cp1 foreign key (idImpression) references Impression(idImpression),
                    constraint i_cp2 foreign key (idPhoto) references Photo(idPhoto));

--################################ CREATION DE LA TABLE PagePhoto ###########################
create table PagePhoto(idPhoto varchar2(245),
                    numPage varchar2(245),
                    constraint pk_pp1 primary key (idPhoto,numPage),
                    constraint i_pp1 foreign key (numPage) references Page(numPage),
                    constraint i_pp2 foreign key (idPhoto) references Photo(idPhoto));

--################################ CREATION DE LA TABLE AgendaPhoto ###########################
create table AgendaPhoto(idImpression varchar2(245),
                    idPhoto varchar2(245),
                    constraint pk_agp1 primary key (idImpression,idPhoto),
                    constraint i_agp1 foreign key (idImpression) references Impression(idImpression),
                    constraint i_agp2 foreign key (idPhoto) references Photo(idPhoto));








