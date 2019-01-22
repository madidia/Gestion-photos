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
DROP TABLE CodePersonnel;
DROP TABLE CodeMarketing;
DROP TABLE Code;
DROP TABLE Operation;
DROP TABLE Administrateur;
DROP TABLE ClientP;
DROP TABLE Utilisateur;


--################################ CREATION DE LA TABLE Utilisateur ###########################
create table Utilisateur(mailU varchar2(245) primary key);


--################################ CREATION DE LA TABLE Client ###########################
create table ClientP(mailC varchar2(245) primary key,
                    nomC varchar2(245) not null,
                    prenomC varchar2(245) not null,
                    mdpasseC varchar2(245) not null,
                    constraint cp_c1 foreign key(mailC) references Utilisateur(mailU));

--################################ CREATION DE LA TABLE Admin ###########################
create table Administrateur(mailA varchar2(245) primary key,
                    nomA varchar2(245) not null,
                    prenomA varchar2(245) not null,
                    mdpasseC varchar2(245) not null,
                    constraint a_c1 foreign key(mailA) references utilisateur(mailU));

--################################ CREATION DE LA TABLE Operation ###########################
create table Operation(dateOp date primary key,
                        detail varchar2(245) not null,
                        mail varchar2(245) not null,
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
                            constraint cop_c1 foreign key (codeCP) references Code(code),
                            constraint cop_c2 foreign key (mailCP) references ClientP(mailC));

--################################ CREATION DE LA TABLE adresseC ###########################
create table adresseC (adresseC varchar2(245) primary key,
                        mailAC varchar2(245) not null,
                        constraint ac_c1 foreign key(mailAC) references ClientP(mailC));


--################################ CREATION DE LA TABLE Article ###########################
create table Article(idArticle varchar2(245) primary key,
                        quantite integer not null,
                        prix Number(5,2) not null);


--################################ CREATION DE LA TABLE Commande ###########################
create table Commande(numCommande varchar2(245) primary key,
                        mail varchar2(245) not null,
                        dateComm date not null,
                        adresseLivraison varchar2(245) not null,
                        statut varchar2(245) not null,
                        montant Number(5,2) not null,
                        code varchar(245),
                        idArticle varchar2(245) not null,
                        quantite integer not null,
                        constraint com_c1 foreign key(mail) references ClientP(mailC),
                        constraint com_c2 foreign key(code) references Code(code),
                        constraint com_c3 foreign key(idArticle) references Article(idArticle),
						constraint com_c4 check (statut in ('en cours','pret a lenvoi','envoyee')));


--################################ CREATION DE LA TABLE Historique ###########################
create table Historique(numCommande varchar2(245) primary key,
                        mail varchar2(245) not null,
                        dateComm date not null,
                        adresseLivraison varchar2(245) not null,
                        statut varchar2(245) not null,
                        montant Number(5,2) not null,
                        code varchar(245),
                        idArticle varchar2(245) not null,
                        quantite integer not null,
                        constraint h_fk1 foreign key(mail) references ClientP(mailC),
                        constraint h_fk2 foreign key(code) references Code(code),
                        constraint h_fk3 foreign key(idArticle) references Article(idArticle),
						constraint h_c4 check (statut in ('en cours','pret a lenvoi','envoyee')));

--################################ CREATION DE LA TABLE Impression ###########################
create table Impression(idImpression varchar2(245) primary key,
                        qualite varchar2(245) not null,
                        idArticle varchar2(245) not null,
						mail varchar2(245) not null,
                        constraint i_fk1 foreign key(idArticle) references Article(idArticle),
						constraint i_fk2 foreign key(mail) references ClientP(mailC));

--################################ CREATION DE LA TABLE Image ###########################
create table Img(chemin varchar2(245) primary key,
                    mail varchar2(245) not null,
		    		resolution varchar2(245) not null,
                    partagee varchar2(3) not null,
                    dateUtilisation date not null,
                    constraint i_c1 foreign key (mail) references ClientP(mailC),
		    		constraint i_c2 check (partagee in('oui','non')));

--################################ CREATION DE LA TABLE Photo ###########################
create table Photo(idPhoto varchar2(245) primary key,
                    chemin varchar2(245) not null,
                    resolution varchar2(245) not null,
                    parametre varchar2(245),
                    constraint i_p1 foreign key (chemin) references Img(chemin));

--################################ CREATION DE LA TABLE Tirage ###########################
create table Tirage(idImpression varchar2(245) primary key,
                    format varchar2(245) not null,
                    constraint i_t1 foreign key (idImpression) references Impression(idImpression));

--################################ CREATION DE LA TABLE Album ###########################
create table Album(idImpression varchar2(245) primary key,
                    couverture varchar2(245) not null,
                    titre varchar2(245) not null,
                    format varchar2(245) not null,
                    constraint a_fk1 foreign key (idImpression) references Impression(idImpression),
					constraint a_fk2 foreign key (couverture) references Photo(idPhoto));

--################################ CREATION DE LA TABLE Calendrier ###########################
create table Calendrier(idImpression varchar2(245) primary key,
                    modele varchar2(245),
                    format varchar2(245),
                    constraint cal_fk1 foreign key (idImpression) references Impression(idImpression));



--################################ CREATION DE LA TABLE Agenda ###########################
create table Agenda(idImpression varchar2(245) primary key,
                    typeAgenda varchar2(245) not null,
                    modele varchar2(245),
                    format varchar2(245),
                    constraint ag_fk1 check (typeAgenda in ('semaine', 'jour')),
                    constraint ag_fk2 foreign key (idImpression) references Impression(idImpression));

--################################ CREATION DE LA TABLE Cadre ###########################
create table Cadre(idImpression varchar2(245) primary key,
                    taille varchar2(245),
                    modele varchar2(245),
                    constraint ca_fk foreign key (idImpression) references Impression(idImpression));

--################################ CREATION DE LA TABLE Page ###########################
create table Pge(numPage varchar2(245) primary key,
                    idImpression varchar2(245),
                    constraint pg_fk foreign key (idImpression) references Impression(idImpression));

--################################ CREATION DE LA TABLE TiragePhoto ###########################
create table TiragePhoto(idImpression varchar2(245),
                    idPhoto varchar2(245),
                    constraint pk_tp1 primary key (idImpression,idPhoto),
                    constraint i_tp1 foreign key (idImpression) references Impression(idImpression),
                    constraint i_tp2 foreign key (idPhoto) references Photo(idPhoto));

--################################ CREATION DE LA TABLE CadrePhoto ###########################
create table CadrePhoto(idImpression varchar2(245),
                    idPhoto varchar2(245),
                    constraint cp_pk primary key (idImpression,idPhoto),
                    constraint cp_fk1 foreign key (idImpression) references Impression(idImpression),
                    constraint cp_fk2 foreign key (idPhoto) references Photo(idPhoto));

--################################ CREATION DE LA TABLE PagePhoto ###########################
create table PagePhoto(idPhoto varchar2(245),
                    numPage varchar2(245),
                    constraint pp_pk primary key (idPhoto,numPage),
                    constraint pp_fk1 foreign key (numPage) references Pge(numPage),
                    constraint pp_fk2 foreign key (idPhoto) references Photo(idPhoto));

--################################ CREATION DE LA TABLE AgendaPhoto ###########################
create table AgendaPhoto(idImpression varchar2(245),
                    idPhoto varchar2(245),
                    constraint agp_pk primary key (idImpression,idPhoto),
                    constraint agp_fk1 foreign key (idImpression) references Impression(idImpression),
                    constraint agp_fk2 foreign key (idPhoto) references Photo(idPhoto));








