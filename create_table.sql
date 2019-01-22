--############################## DROP TABLE IN DATABASE #####################################
DROP TABLE AgendaPhoto;
DROP TABLE PagePhoto;
DROP TABLE CadrePhoto;
DROP TABLE TiragePhoto;
DROP TABLE Pge;
DROP TABLE Cadre;
DROP TABLE Agenda;
DROP TABLE Calendrier;
DROP TABLE Album ;
DROP TABLE Tirage CASCADE CONSTRAINT;
DROP TABLE Photo CASCADE CONSTRAINT;
DROP TABLE UtiliseImage CASCADE CONSTRAINT;
DROP TABLE Img CASCADE CONSTRAINT;
DROP TABLE Impression CASCADE CONSTRAINT;
DROP TABLE Support CASCADE CONSTRAINT;
DROP TABLE Historique CASCADE CONSTRAINT;
DROP TABLE Commande CASCADE CONSTRAINT;

DROP TABLE CodePersonnel;
DROP TABLE CodeMarketing;
DROP TABLE Code;


DROP TABLE adresse;
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
                    constraint cp_c1 foreign key(mailC) references Utilisateur(mailU) ON DELETE CASCADE);

--################################ CREATION DE LA TABLE Admin ###########################
create table Administrateur(mailA varchar2(245) primary key,
                    nomA varchar2(245) not null,
                    prenomA varchar2(245) not null,
                    mdpasseA varchar2(245) not null,
                    constraint a_c1 foreign key(mailA) references utilisateur(mailU) ON DELETE CASCADE);

--################################ CREATION DE LA TABLE Operation ###########################
create table Operation(dateOp date primary key,
                        detail varchar2(245) not null,
                        mail varchar2(245) not null,
                        constraint o_c1 foreign key (mail) references Administrateur(mailA)ON DELETE CASCADE);

--################################ CREATION DE LA TABLE Code ###########################
create table Code(code integer primary key,
		 valeur integer not null);


--################################ CREATION DE LA TABLE CodeMarketing ###########################
create table CodeMarketing(codeCM integer primary key,
                            valeurCM integer not null,
                            constraint cm_c1 foreign key (codeCM) references Code(code)ON DELETE CASCADE);

--################################ CREATION DE LA TABLE CodePersonnel ###########################
create table CodePersonnel(CodeCP integer primary key,
                            valeurCP integer not null,
                            mailCP varchar2(245) not null,
                            constraint cop_c1 foreign key (codeCP) references Code(code) ON DELETE CASCADE,
                            constraint cop_c2 foreign key (mailCP) references ClientP(mailC) ON DELETE CASCADE);

--################################ CREATION DE LA TABLE adresseC ###########################
create table Adresse (idAdresse integer primary key,
						adresseC varchar2(245),
                        mailAC varchar2(245) not null,
                        constraint ac_c1 foreign key(mailAC) references ClientP(mailC)ON DELETE CASCADE);

--################################ CREATION DE LA TABLE Commande ###########################
create table Commande(numCommande integer primary key,
                        mail varchar2(245) not null,
                        dateComm date not null,
                        idAdresse integer not null,
                        statut varchar2(245) not null,
                        montant Number(5,2) not null,
                        code integer,
                        constraint com_c1 foreign key(mail) references ClientP(mailC) ON DELETE CASCADE,
                        constraint com_c2 foreign key(code) references Code(code) ON DELETE CASCADE,
					    constraint com_c3 foreign key(idAdresse) references Adresse(idAdresse) ON DELETE CASCADE,
						constraint com_c4 check (statut in ('en cours','pret a lenvoi','envoyee')));

--################################ CREATION DE LA TABLE Historique ###########################
create table Historique(numCommande integer primary key,
                        mail varchar2(245) not null,
                        dateComm date not null,
                        idAdresse integer not null,
                        statut varchar2(245) not null,
                        montant Number(5,2) not null,
                        code integer,
                        constraint h_fk1 foreign key(mail) references ClientP(mailC) ON DELETE CASCADE,
                        constraint h_fk2 foreign key(code) references Code(code) ON DELETE CASCADE,
			constraint h_c4 check (statut in ('en cours','pret a lenvoi','envoyee')));


--################################ CREATION DE LA TABLE Image ###########################
create table Img(chemin varchar2(245) primary key,
                 mail varchar2(245) not null,
		 		 resolution number(7,2) not null,
                 partagee varchar2(3) not null,
                 dateUtilisation date not null,
                 constraint i_c1 foreign key (mail) references ClientP(mailC) ON DELETE CASCADE,
		 		 constraint i_c2 check (partagee in('oui','non')));

--################################ CREATION DE LA TABLE UtiliseImage ###########################
create table UtiliseImage(mail varchar2(245) not null,
			  chemin varchar2(245) not null,
                          dateUtilisation date not null,
                 	  constraint i_pk1 primary key (mail,chemin,dateUtilisation),
			  constraint ui_fk1 foreign key (mail) references ClientP(mailC) ON DELETE CASCADE,
			  constraint ui_fk2 foreign key (chemin) references Img(chemin) ON DELETE CASCADE);

--################################ CREATION DE LA TABLE Photo ###########################
create table Photo(idPhoto integer primary key,
                    chemin varchar2(245) not null,
                    resolution number(7,2) not null,
                    parametre varchar2(245),
                    constraint photo_fk1 foreign key (chemin) references Img(chemin) ON DELETE CASCADE);

--?????????????################################ CREATION DE LA TABLE Support ###########################
create table Support(type varchar2(245) not null,
		     format varchar2(245) not null,
		     qualite varchar2(245) not null,
                     quantiteStock integer not null,
                     pu number(7,2) not null,
                     constraint supp_pk primary key(type,format,qualite));

--?????????????################################ CREATION DE LA TABLE Impression ###########################
create table Impression(idImpression integer primary key,
			format varchar2(245) not null,
                        qualite varchar2(245) not null,
 			nbExemplaire integer not null,
			numCommande integer not null,
                        formatSupport varchar2(245) not null,
			qualiteSupport varchar2(245) not null,
			typeSupport varchar2(245) not null,
    			constraint i_fk1 foreign key(typeSupport,formatSupport,qualiteSupport) references Support(type,format,qualite) ON DELETE CASCADE,
			constraint i_fk2 foreign key(numCommande) references Commande(numCommande) ON DELETE CASCADE);

--################################ CREATION DE LA TABLE Tirage ###########################
create table Tirage(idImpression integer primary key,
					format varchar2(245) not null,
                    qualite varchar2(245) not null,
                    constraint tirage_fk1 foreign key (idImpression) references Impression(idImpression) ON DELETE CASCADE);

--################################ CREATION DE LA TABLE Album ###########################
create table Album(idImpression integer primary key,
		   		   format varchar2(245) not null,
                   qualite varchar2(245) not null,
                   couverture integer not null,
                   titre varchar2(245) not null,
                   constraint a_fk1 foreign key (idImpression) references Impression(idImpression) ON DELETE CASCADE,
		   		   constraint a_fk2 foreign key (couverture) references Photo(idPhoto) ON DELETE CASCADE);

--################################ CREATION DE LA TABLE Calendrier ###########################
create table Calendrier(idImpression integer primary key,
						format varchar2(245) not null,
                        qualite varchar2(245) not null,
                        modele varchar2(245),
                        constraint cal_fk1 foreign key (idImpression) references Impression(idImpression) ON DELETE CASCADE);

--################################ CREATION DE LA TABLE Agenda ###########################
create table Agenda(idImpression integer primary key,
		    	    format varchar2(245) not null,
                    qualite varchar2(245) not null,
                    typeAgenda varchar2(245) not null,
                    modele varchar2(245),
                    constraint ag_fk1 check (typeAgenda in ('semaine', 'jour')),
                    constraint ag_fk2 foreign key (idImpression) references Impression(idImpression) ON DELETE CASCADE);

--################################ CREATION DE LA TABLE Cadre ###########################
create table Cadre(idImpression integer primary key,
		   		   format varchar2(245) not null,
                   qualite varchar2(245) not null,
                   taille varchar2(245),
                   modele varchar2(245),
                   constraint ca_fk foreign key (idImpression) references Impression(idImpression) ON DELETE CASCADE);

--################################ CREATION DE LA TABLE Page ###########################
create table Pge(idPage integer primary key,
		 	     numPage integer,
                 idImpression integer,
                 constraint pg_fk foreign key (idImpression) references Impression(idImpression) ON DELETE CASCADE);

--################################ CREATION DE LA TABLE TiragePhoto ###########################
create table TiragePhoto(idImpression integer,
                    	 idPhoto integer,
		    			 nbExemplaire integer,
                         constraint pk_tp1 primary key (idImpression,idPhoto),
                         constraint tp_fk1 foreign key (idImpression) references Impression(idImpression) ON DELETE CASCADE,
                         constraint tp_fk2 foreign key (idPhoto) references Photo(idPhoto) ON DELETE CASCADE);

--################################ CREATION DE LA TABLE CadrePhoto ###########################
create table CadrePhoto(idImpression integer,
                    idPhoto integer,
                    constraint cp_pk primary key (idImpression,idPhoto),
                    constraint cp_fk1 foreign key (idImpression) references Impression(idImpression) ON DELETE CASCADE,
                    constraint cp_fk2 foreign key (idPhoto) references Photo(idPhoto) ON DELETE CASCADE);

--################################ CREATION DE LA TABLE PagePhoto ###########################
create table PagePhoto(idPhoto integer,
                    idPage integer,
                    constraint pp_pk primary key (idPhoto,idPage),
                    constraint pp_fk1 foreign key (idPhoto) references Photo(idPhoto) ON DELETE CASCADE,
					constraint pp_fk2 foreign key (idPage) references Pge(idPage) ON DELETE CASCADE);

--################################ CREATION DE LA TABLE AgendaPhoto ###########################
create table AgendaPhoto(idImpression integer,
                    idPhoto integer,
                    constraint agp_pk primary key (idImpression,idPhoto),
                    constraint agp_fk1 foreign key (idImpression) references Impression(idImpression) ON DELETE CASCADE,
                    constraint agp_fk2 foreign key (idPhoto) references Photo(idPhoto) ON DELETE CASCADE);
