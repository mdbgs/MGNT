drop database if exists ceamitic; 
create database ceamitic;
use ceamitic;
/*==============================================================*/
/* Table : Activite                                             */
/*==============================================================*/
create table Activite 
(
   IDactivite         integer                        not null AUTO_INCREMENT,
   libelle              varchar(354)                   not null,
   periode                date                   		 null,
   echeancePrevu        varchar(200)                      null,
   echeanceRealise      varchar(200)                   null,
   statutActivite       varchar(50)                  not  null,
   natureIndicateur     varchar(100)                   null,
   libelleIndicateur    varchar(500)                   null,
   referenceTableauDeSaisie varchar(200)                   null,
   pieceJustificatif    varchar(200)                   null,
   composant     varchar(200)                   null,
   objectif     varchar(250)                   null,
   resultatAttendu     varchar(200)                   null,
   constraint PK_ACTIVITE primary key (IDactivite),
   constraint AK_INDICATEURID_ACTIVITE unique (IDactivite)
);
/*==============================================================*/
/* Table : Animateur_Relecteur                                  */
/*==============================================================*/
create table Animateur_Relecteur 
(
   iDAnimateur          integer                        not null AUTO_INCREMENT,
   iDpartenaire         integer                        not null ,
   pseudo             varchar(255)                    not null,
   nom                  varchar(100)                   not null,
   prenom               varchar(100)                   not null,
   mail                 varchar(100)                   not null,
   telephone            varchar(35)                   not null,
   boitePostale         varchar(35)                   null,
   affliationInstitutionnel varchar(100)                  not  null,
   type                 varchar(35)                  not null,
   constraint PK_Anim primary key (iDAnimateur),
   constraint AK_anim unique (iDAnimateur)
);


/*==============================================================*/
/* Table : Compte                                               */
/*==============================================================*/
create table Compte 
(
   pseudo             varchar(255)                    not null,
   password             varchar(500)                    not null,
   dateinscription            datetime                    default null,
   photo				VARCHAR(500) 							  null,
   statut				varchar(10)						not null,
   constraint PK_COMPTE primary key clustered (pseudo),
   constraint AK_IDETUDIANT_ENSEIGNA unique (pseudo)
);

/*==============================================================*/
/* Table : Enseignant                                           */
/*==============================================================*/
create table Enseignant 
(
   iDEnseignat          integer                        not null AUTO_INCREMENT,
   pseudo             varchar(255)                    not null,
   nom                  varchar(100)                   null,
   prenom               varchar(100)                   null,
   grade               varchar(100)                   null,
   nationalite          varchar(100)                   null,
   adresse              varchar(500)                   null,
   email                varchar(100)                   null,
   telephone            varchar(100)                   null,
   bp                   varchar(100)                   null,
   sexe                 integer                        null,
   anneeDenseignement	varchar(255)				   null,
   affliationInstitutionnel varchar(100)                        null,
   constraint PK_ENSEIGNANT primary key (iDEnseignat),
   constraint AK_IDETUDIANT_ENSEIGNA unique (iDEnseignat)
);

/*==============================================================*/
/* Table : Etudiant                                             */
/*==============================================================*/
create table Etudiant 
(
   iDEtudiant           integer                        not null AUTO_INCREMENT,
   pseudo             varchar(255)                    not null,
   nom                  varchar(100)                   null,
   prenom               varchar(100)                   null,
   dateNaissance       datetime                    default null,
   lieuNaissance        varchar(100)                   null,
   niveau               varchar(100)                   null,
   nationalite          varchar(100)                   null,
   adresse              varchar(500)                   null,
   email                varchar(100)                   null,
   telephone            varchar(100)                   null,
   bp                   varchar(100)                   null,
   sexe                 integer                        null,
   numeroEtudiant       varchar(100)                  not null,
   pacNom               varchar(100)                   null,
   pacPrenom            varchar(100)                   null,
   pacTel               varchar(100)                   null,
   pacAdresse           varchar(100)                   null,
   programme            varchar(100)                   null,
   semestre             varchar(100)                   null,
   anneeInscription		varchar(100)					null,
   constraint PK_ETUDIANT primary key (iDEtudiant),
   constraint AK_IDEtudiant unique (iDEtudiant),
   constraint AK_NUmEtudiant unique (numeroEtudiant)
);
/*==============================================================*/
/* Table : Formation                                            */
/*==============================================================*/
create table Formation 
(
   IDFormation          integer                        not null AUTO_INCREMENT,
   titre                varchar(100)                   null,
   institution          varchar(100)                   null,
   position             varchar(100)                      null,
   contenu              varchar(354)                   null,
   constraint PK_FORMATION primary key (IDFormation),
   constraint AK_INDICATEURID_FORMATIO unique (IDFormation)
);

/*==============================================================*/
/* Table : Partenaires                                          */
/*==============================================================*/
create table Partenaires 
(
   iDpartenaire         integer                        not null AUTO_INCREMENT,
   pseudo             varchar(255)                    not null,
   nom                  varchar(100)                   null,
   type                 varchar(100)                   null,
   adresse              varchar(100)                   null,
   telephone            varchar(100)                   null,
   email                varchar(100)                   null,
   boitePostale         varchar(100)                   null,
   titreAccord          varchar(100)                   null,
   domaineDeCollaboration varchar(100)                   null,
   dateSignature        datetime                    default null,
   expirationAccord     varchar(100)                   null,
   resultatAttendu      varchar(2100)                   null,
   projetConjoint       varchar(100)                   null,
   constraint PK_PARTENAIRES primary key (iDpartenaire)
);


/*==============================================================*/
/* Table : ProgrammeCea                                         */
/*==============================================================*/
create table ProgrammeCea 
(
   iDProgramme          integer                         not null AUTO_INCREMENT,
   titre                varchar(100)                   null,
   niveau               varchar(100)                   null,
   typeAccreditation    varchar(100)                   null,
   referenceAccreditation varchar(100)                   null,
   nomAgenceD_accreditaion varchar(100)                   null,
   mailAgence           varchar(100)                   null,
   telAgence            varchar(100)                   null,
   bpAgence             varchar(100)                   null,
   dateAccreditation    datetime                    default null,
   dateExpiration       datetime                    default null,
   type                 varchar(100)                        null,
   statut               varchar(100)                        null,
   offertPar            varchar(100)                        null,
   dateCreation         datetime                    default null,
   constraint PK_Programme primary key (iDProgramme)
);

/*==============================================================*/
/* Table : "Publication"                                        */
/*==============================================================*/
create table Publication 
(
   iDpublication        integer                        not null AUTO_INCREMENT,
   iDResponsable        integer                        not null,
   titre                varchar(100)                   null,
   datePublication     datetime                    default null,
   nomJournal           varchar(100)                   null,
   auteurs              varchar(100)                   null,
   impactFactor         varchar(100)                   null,
   constraint PK_PUBLICATION primary key (iDpublication)
);

/*==============================================================*/
/* Table : Responsable                                          */
/*==============================================================*/
create table Responsable 
(
   iDResponsable        integer                        not null AUTO_INCREMENT,
   pseudo             varchar(255)                    not null,
   nom                  varchar(100)                   null,
   prenom               varchar(100)                   null,
   adresse              varchar(100)                   null,
   telephone            varchar(100)                   null,
   mail                 varchar(100)                   null,
   sexe                 integer                   null,
   poste                varchar(100)                   null,
   type                 varchar(100)                   null,
   constraint PK_RESPONSABLE primary key (iDResponsable)
);
create table ResponsableActivite{
	pseudo responsable varchar(255)  not null,
	idActivite varchar(255)    not null,
	constraint PK_ResponsableActivite primary key (pseudo,idActivite)
};
/*==============================================================*/
/* Table : Reunion                                              */
/*==============================================================*/
create table Reunion 
(
   iDReunion            integer                        not null AUTO_INCREMENT,
   iDResponsable        integer                        not null,
   type                 varchar(100)                   null,
   dateDebut            datetime                    default null,
   dateFin              datetime                    default null,
   objet                varchar(100)                   null,
   nombreParticipant    integer                        null,
   lieu                 varchar(100)                   null,
   compteRendu          varchar(500)                        null,
   pieceJustificatif	varchar(500)							  null,
   constraint PK_REUNION primary key (iDReunion)
);

/*==============================================================*/
/* Table : Stage                                                */
/*==============================================================*/
create table Stage 
(
   iDStage              integer                        not null AUTO_INCREMENT,
   iDEnseignat          integer                         null,
   iDEtudiant           integer                         null,
   iDpartenaire         integer                         null,
   programme_Departement varchar(100)                   null,
   dateDebut            datetime                    default null,
   dateFin              datetime                    default null,
   certificat           varchar(35)                        null,
   nomInstitution       varchar(35)                        null,
   statueInstitution    varchar(35)                        null,
   nomDirecteur         varchar(35)                        null,
   prenomDirecteur      varchar(35)                        null,
   mailDirecteur        varchar(35)                        null,
   telDirecteur         varchar(35)                        null,
   constraint PK_STAGE primary key (iDStage)
);
CREATE TABLE roles (
rolename varchar(120) NOT NULL PRIMARY KEY
);
CREATE TABLE users_roles (
   pseudo             varchar(255)                    not null,
   rolename varchar(120) NOT NULL,
PRIMARY KEY (pseudo, rolename),
CONSTRAINT users_roles_fk1 FOREIGN KEY (pseudo) REFERENCES compte (pseudo),
CONSTRAINT users_roles_fk2 FOREIGN KEY (rolename) REFERENCES roles (rolename)
);

/*==============================================================*/
/* Table : relecteurProgramme                                   */
/*==============================================================*/
create table relecteurProgramme 
(
   iDAnimateur          integer                        not null,
   iDProgramme          integer                        not null,
   date_de_revision     date                           not null,
   constraint PK_RELECTEURPROGRAMME primary key clustered (iDAnimateur,iDProgramme,date_de_revision)
);

/*==============================================================*/
/* Table : Indicateur                                           */
/*==============================================================*/
create table Indicateur 
(
   idIndicateur          integer                        not null AUTO_INCREMENT,
   numero		integer							not null,
   libelle          	varchar(255)                    not null,
   objectif				varchar(255)         			null,
   sigle				varchar(15)         			null,
   constraint PK_indicateur primary key clustered (idIndicateur)
);
insert into Indicateur values 
	(null,1,'SUIVI DES INSCRIPTIONS DES ETUDIANTS DU CEA','Regionalit�','SIEC'),
	(null,2,'SUIVI DES PROGRAMMES DU CEA','Qualit� de la formation','SPC'),
	(null,3,'SUIVI DES STAGES','Sensibilisation','SDS'),
	(null,5,'SUIVI DE LA FORMATION DES ENSEIGNANTS','Qualit� de la formation','SFE'),
	(null,6,'SUIVI DES PROGRAMMES NOUVELLEMENT CREES OU REVISES','Qualit� de la formation','SPNCR'),
	(null,9,'SUIVI DES PARTENARIATS','Sensibilisation/R�gionalit�','SDP'),
	(null,10,'SUIVI DES REUNIONS','Administration / Gouvernance Qualit� FM','SDR');
alter table Animateur_Relecteur
   add constraint FK_ANIMATEU_PARTENAIR_PARTENAI foreign key (iDpartenaire)
      references Partenaires (iDpartenaire)
      on update cascade
      on delete cascade;
alter table Animateur_Relecteur
   add constraint FK_ANIMATEU_Compte foreign key (pseudo)
      references compte (pseudo)
      on update cascade
      on delete cascade;

alter table Enseignant
   add constraint FK_ENSEIGNA_ENSEIGNAN_COMPTE foreign key (pseudo)
      references Compte (pseudo)
      on update cascade
      on delete cascade;

alter table Etudiant
   add constraint FK_ETUDIANT_ETUDIANTC_COMPTE foreign key (pseudo)
      references Compte (pseudo)
      on update cascade
      on delete cascade;
	  
alter table Responsable_Activite
   add constraint FK_ResponsableActivite_COMPTE foreign key (pseudo)
      references Compte (pseudo)
      on update cascade
      on delete cascade;
	  
alter table Responsable_Activite
   add constraint FK_ResponsableActivite_Activite foreign key (idActivite)
      references Activite (idActivite)
      on update cascade
      on delete cascade;

	  
alter table Partenaires
   add constraint FK_Partenaire_COMPTE foreign key (pseudo)
      references Compte (pseudo)
      on update cascade
      on delete cascade;
	  
	  
alter table Publication
   add constraint FK_PUBLICAT_PUBLICATI_RESPONSA foreign key (iDResponsable)
      references Responsable (iDResponsable)
      on update cascade
      on delete cascade;

alter table Responsable
   add constraint FK_RESPONSA_RESPONSAB_COMPTE foreign key (pseudo)
      references Compte (pseudo)
      on update cascade
      on delete cascade;

alter table Reunion
   add constraint FK_REUNION_RESPONSAB_RESPONSA foreign key (iDResponsable)
      references Responsable (iDResponsable)
      on update cascade
      on delete cascade;

alter table Stage
   add constraint FK_STAGE_ETUDIANTS_ETUDIANT foreign key (iDEtudiant)
      references Etudiant (iDEtudiant)
      on update cascade
      on delete cascade;

alter table Stage
   add constraint FK_STAGE_STAGEENSE_ENSEIGNA foreign key (iDEnseignat)
      references Enseignant (iDEnseignat)
      on update cascade
      on delete cascade;

alter table Stage
   add constraint FK_STAGE_STAGEPART_PARTENAI foreign key (iDpartenaire)
      references Partenaires (iDpartenaire)
      on update cascade
      on delete cascade;


/*Insertion des comptes d'utilisateur de la plateforme */
insert into compte values('m.sall','A80ZK��%k0K��5%kRK��RPKZ���l#HPA8',2016/04/04,'','actif');
insert into compte values('mme.sy','A80ZK��%k0K��5%kRK��RPKZ���l#HPA8',2016/04/04,'','actif');
insert into compte values('mlle.thiam','A80ZK��%k0K��5%kRK��RPKZ���l#HPA8',2016/04/04,'','actif');
insert into compte values('m.dembele','A80ZK��%k0K��5%kRK��RPKZ���l#HPA8',2016/04/04,'','actif');
insert into compte values('m.lo','A80ZK��%k0K��5%kRK��RPKZ���l#HPA8',2016/04/04,'','actif');
insert into compte values('m.diop','A80ZK��%k0K��5%kRK��RPKZ���l#HPA8',2016/04/04,'','actif');
insert into compte values('m.ndiaye','A80ZK��%k0K��5%kRK��RPKZ���l#HPA8',2016/04/04,'','actif');
insert into compte values('ucad','A80ZK��%k0K��5%kRK��RPKZ���l#HPA8',2016/04/04,'','actif');
insert into compte values('worldBank','A80ZK��%k0K��5%kRK��RPKZ���l#HPA8',2016/04/04,'','actif');
insert into compte values('m.maiga','A80ZK��%k0K��5%kRK��RPKZ���l#HPA8',2016/04/04,'','actif');
/*Insertion des differentes roles de l'application*/
INSERT INTO roles VALUES ('admin');
INSERT INTO roles VALUES ('etudiant');
INSERT INTO roles VALUES ('enseignat');
INSERT INTO roles VALUES ('coordonnateur');
INSERT INTO roles VALUES ('responsable_Suivi_Evaluation');
INSERT INTO roles VALUES ('responsable_Saisie');
INSERT INTO roles VALUES ('responsable_Controle');
INSERT INTO roles VALUES ('partenaire');
INSERT INTO roles VALUES ('BanqueMondial');
INSERT INTO roles VALUES ('viceCoordonnateur');
/*Attribution des r�les aux utilisateurs */
INSERT INTO users_roles  VALUES ('m.sall', 'admin');
INSERT INTO users_roles  VALUES ('mme.sy', 'responsable_Suivi_Evaluation');
INSERT INTO users_roles  VALUES ('m.dembele', 'enseignat');
INSERT INTO users_roles  VALUES ('m.lo', 'coordonnateur');
INSERT INTO users_roles  VALUES ('m.ndiaye', 'responsable_Saisie');
INSERT INTO users_roles  VALUES ('m.diop', 'responsable_Controle');
INSERT INTO users_roles  VALUES ('ucad', 'partenaire');
INSERT INTO users_roles  VALUES ('worldBank', 'BanqueMondial');
INSERT INTO users_roles  VALUES ('m.maiga', 'viceCoordonnateur');
INSERT INTO users_roles  VALUES ('mlle.thiam', 'etudiant');
/* insertion des utilisateurs standard*/
INSERT INTO responsable  VALUES (null, 'm.sall','Sall','Moussa','A�noumady 5','772349186','sall.moussa@sanarsoft.com','1','Admin','admin');
INSERT INTO responsable  VALUES (null, 'mme.sy','Ndeye Aminata Diagne','Sy','Saint-Louis','77777777','inconnue','0','Responsable de suivie et �valuation','responsable_Suivi_Evaluation');
INSERT INTO responsable  VALUES (null, 'm.lo','Moussa','Lo','Ngallele','inconnue','moussa.lo@ugb.edu.sn','1','Coordonnateur du CEAMITIC','coordonnateur');
INSERT INTO responsable  VALUES (null, 'm.ndiaye','Di�ne','Ndiaye','Saint-Louis','inconnue','diene.ndiaye@ugb.edu.sn','1','responsable saisie','responsable_Saisie');
INSERT INTO responsable  VALUES (null, 'm.diop','Cheikh Talibouya','Diop','Saint-Louis','inconnue','cheikh.talibouya.diop@ugb.edu.sn','1','responsable contr�le','responsable_Controle');
INSERT INTO responsable  VALUES (null, 'm.maiga','Monsieur','maiga','Saint-Louis','inconnue','mamadou.maiga@ugb.edu.sn','1','vice Coordonnateur','viceCoordonnateur');
insert into enseignant values(null,'m.dembele','Dembele','Jean Marie','Enseignant Chercheur','S�n�galaise','Dakar','m.dembele@gmail.com','inconnue','234',1,'ugb','2015-2016');
insert into etudiant values (null,'mlle.thiam', 'Awa','Thiam','1992/12/12','ngnith','master II','S�n�galaise','ngnith','thiameva21@hotmail.com','776683547','234','0','P22101','Thiam','rokhaya','770175867','hlm dakar','Informatique','semestre 1','2015-2016');
insert into partenaires values (null,'ucad', 'Universit� cheikh Anta Diop','p�dagogique','Point E Dakar','inconnue','contact@ucad.sn','inconnu','partenariat','science de l''ingenierie','2016/12/12','2050/12/12','excellence dans les TICS','Etudes des maladies v�hicul�es par les rongeurs au s�n�gal');
insert into partenaires values (null,'worldBank', 'Banque Mondiale','financier','inconnu','inconnue','contact@ucad.sn','inconnu','partenariat','financi�re','2016/12/12','2050/12/12','excellence dans les TICS','Etudes des maladies v�hicul�es par les rongeurs au s�n�gal');

INSERT INTO Activite VALUES
	(null,
	'Renforcer les formations de master et doctorales existantes  ( Recruter professeurs invit�s et membres de jury de th�se, chercheurs instituts de recherche)',
	null,
	'Mai - D�cembre 2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'Indicateur de r�alisation',
	'le nombre de professeurs, de membres de jury de th�se et invit�s',
	'Hors template',
	'a uploader','Excellence en apprentissage','Atteindre l''excellence de la formation  en STEM � travers la promotion des STEM, l''innovation p�dagogique, l''am�lioration du plateau technique et la promotion de la qualit�.',' La qualit� de l''enseignement et de l''apprentissage est am�lior�e'
	),
	(null,
	'Faire participer les professionnels dans la formation',
	null,
	'Mai - D�cembre 2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'Indicateur de r�alisation',
	'le nombre de professionnels ( de chercheurs d''insttuts) intervenants dans les formations',
	'Hors template',
	'a uploader',
	'Excellence en apprentissage',
	'Atteindre l''excellence de la formation  en STEM � travers la promotion des STEM, l''innovation p�dagogique, l''am�lioration du plateau technique et la promotion de la qualit�.',
	' La qualit� de l''enseignement et de l''apprentissage est am�lior�e'
	),
	(null,
	'Former les enseignants � l''approche par comp�tence ',
	null,
	'Juin-D�cembre 2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'Indicateur de performance',
	'Nombre de PER (nationaux et r�gionaux form�s par le CEA',
	'indicateur 5',
	'a uploader',
	'Excellence en apprentissage',
	'Atteindre l''excellence de la formation  en STEM � travers la promotion des STEM, l''innovation p�dagogique, l''am�lioration du plateau technique et la promotion de la qualit�.',
	' La qualit� de l''enseignement et de l''apprentissage est am�lior�e'
	),
	(null,
	'Elaborer les programmes de Master (r�vis�s et nouveaux)',
	null,
	'Juin-Juillet 2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'Indicateur de performance',
	'Nombre de Master r�vis�s / cr��s',
	'Hors template',
	'a uploader',
	'Excellence en apprentissage',
	'Atteindre l''excellence de la formation  en STEM � travers la promotion des STEM, l''innovation p�dagogique, l''am�lioration du plateau technique et la promotion de la qualit�.',
	' La qualit� de l''enseignement et de l''apprentissage est am�lior�e'
	),
	(null,
	'Accompagner la recherche des stages de fin d''�tudes pour les �tudiants dans les entreprises et centres de recherche',
	null,
	'Janvier -D�cembre 2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'Indicateur de performance',
	'Nombre d''�tudiants et de professeurs en stage pendant au moins 1 mois',
	'indicateur 3',
	'a uploader',
	'Excellence en apprentissage',
	'Atteindre l''excellence de la formation  en STEM � travers la promotion des STEM, l''innovation p�dagogique, l''am�lioration du plateau technique et la promotion de la qualit�.',
	' La qualit� de l''enseignement et de l''apprentissage est am�lior�e'
	),
	(null,
	'Organiser des activit�s de sensibilisation (forums, olympiades, salons, s�minaires de formation des formateurs) et d''orientation dans les diff�rents domaines des STEM',
	null,
	'Janvier -D�cembre 2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'Indicateur de r�alisation',
	'Tx de participation (eleves, enseignants, etc.)',
	'Hors template',
	'a uploader',
	'Excellence en apprentissage',
	'Atteindre l''excellence de la formation  en STEM � travers la promotion des STEM, l''innovation p�dagogique, l''am�lioration du plateau technique et la promotion de la qualit�.',
	' La qualit� de l''enseignement et de l''apprentissage est am�lior�e'
	),
	(null,
	'Mettre � niveau les �tudiants de Master et Doctorat via des FOAD en anglais',
	null,
	'Mai - D�cembre 2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'indicateur de r�alisation et indicateur de performance ',
	'Nombre d''�tudiants r�gionaux et nationaux inscrits au Master, PHD, short courses',
	'indicateur 1',
	'a uploader',
	'Excellence en apprentissage',
	'Atteindre l''excellence de la formation  en STEM � travers la promotion des STEM, l''innovation p�dagogique, l''am�lioration du plateau technique et la promotion de la qualit�.',
	' La qualit� de l''enseignement et de l''apprentissage est am�lior�e'
	),
	(null,
	'Financer des Projets de recherche',
	null,
	'JAnvier - D�cembre 2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'Indicateur de r�alisation',
	'Nombre de chercheurs  r�gionaux et nationaux ayant recu un financement de projet de recherche par le CEA MITIC',
	'Hors template',
	'a uploader',
	'Excellence dans la recherche',
	'Cr�er les conditions et l''environnement pour une recherche de qualit� en Math�matiques, Informatique et TI',
	'Le Nombre de doctorants dans les STEMS et le taux d''encadrement doctoral sont am�lior�s'
	),
	(null,
	'Financer les Bourses doctorales (hors projets)',
	null,
	'Janvier - D�cembre 2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'Nbre d''�tudiants r�gionaux et nationaux ayant re�u une bourse doctorale du CEA MITIC',
	'le nombre de professionnels ( de chercheurs d''insttuts) intervenants dans les formations',
	'indicateur 1',
	'a uploader',
	'Excellence dans la recherche',
	'Cr�er les conditions et l''environnement pour une recherche de qualit� en Math�matiques, Informatique et TI',
	'Le Nombre de doctorants dans les STEMS et le taux d''encadrement doctoral sont am�lior�s'
	),
	(null,
	'Financer la Mobilit� de recherches',
	null,
	'Janvier - D�cembre 2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'Indicateur de r�alisation',
	'Nombre de chercheurs r�gionaux et nationaux ayant re�u un financement pour la mobilit� de recherche du CEA MITIC',
	'Hors template',
	'a uploader',
	'Excellence dans la recherche',
	'Cr�er les conditions et l''environnement pour une recherche de qualit� en Math�matiques, Informatique et TI',
	'Le Nombre de doctorants dans les STEMS et le taux d''encadrement doctoral sont am�lior�s'
	),
	(null,
	'Soutenir les  publications scientifiques',
	null,
	'Janvier - D�cembre 2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'indicateur de performance indicateur de r�alisation',
	'Nombre de publications scientifiques (nationales et internationales) ayant �t� soutenues par le CEA MITIC',
	'indicateur 7',
	'voir template tableau indicateur 7',
	'Excellence dans la recherche',
	'Cr�er les conditions et l''environnement pour une recherche de qualit� en Math�matiques, Informatique et TI',
	'Le Nombre de doctorants dans les STEMS et le taux d''encadrement doctoral sont am�lior�s'
	),
	(null,
	'Organiser et participer � des  conf�rences internationales',
	null,
	'Janvier - D�cembre 2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'Indicateur de r�alisation',
	'Nombre chercheurs et de partenaires ayant organis� et particip� � des conf�rences internationales',
	'Hors template',
	'a uploader',
	'Excellence dans la recherche',
	'Cr�er les conditions et l''environnement pour une recherche de qualit� en Math�matiques, Informatique et TI',
	'Le Nombre de doctorants dans les STEMS et le taux d''encadrement doctoral sont am�lior�s'
	),
	(null,
	'Mettre en place des programmes de bourses d''excellence (meilleurs �tudiants, filles, etc.)',
	null,
	'Mai - D�cembre 2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'indicateur de performance indicateur de r�alisation',
	'Nbre d''�tudiants r�gionaux et nationaux ayant re�u une bourse d''excellence du CEA MITIC',
	'indicateur 1',
	'a uploader',
	'Partenariat ',
	'Devenir le Centre STEM de convergences pr�f�r� des professeurs et �tudiants au niveau r�gional',
	'Le nombre d''�tudiants, d''enseignants-chercheurs et chercheurs au niveau r�gional s�journant au CEA accru'
	),
	(null,
	'Mener des missions de sensibilisation/marketing et vulgarisation dans la sous-r�gion',
	null,
	'Juillet-Octobre 2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'indicateur de performance indicateur de r�alisation',
	'Nombre de conventions sign�s avec les partenaires r�gionaux Nombre de rencontres /missions effectu�es dans la sous r�gion',
	'indicateur 9%indicateur 10',
	'Conventions sign�es CR Missions ou rencontres avec les partenaires',
	'Partenariat ',
	'Devenir le Centre STEM de convergences pr�f�r� des professeurs et �tudiants au niveau r�gional',
	'Le nombre d''�tudiants, d''enseignants-chercheurs et chercheurs au niveau r�gional s�journant au CEA accru'
	),
	(null,
	'Rencontrer les partenaires nationaux (acad�miques et industriels)',
	null,
	'Janvier - D�cembre 2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'Rencontrer les partenaires nationaux (acad�miques et industriels)',
	'Nombre de conventions sign�s avec les partenaires acad�miques et industriels nationaux Nombre de rencontres /missions effectu�es au S�n�gal',
	'indicateur 9%indicateur 10',
	'a uploader',
	'Partenariat ',
	'Contribuer � renforcer la performance en mati�re d''apprentissage et d''enseignement et la performance en mati�re de recherche dans les institutions acad�miques nationales  et sous-r�gionales partenaires',
	'La qualit� de l''enseignement et de la recherche dans les institutions acad�miques partenaires est am�lior�e'
	),
	(null,
	'Conduire et appuyer des missions d''enseignement et de recherche dans les institutions partenaires',
	null,
	'Janvier - D�cembre 2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'Indicateur de r�alisation',
	'Nombre de  missions d''enseignement et de recherche effectu�s dans les institutions partenaires partenaires',
	'Hors template',
	'a uploader',
	'Partenariat ',
	'Contribuer � renforcer la performance en mati�re d''apprentissage et d''enseignement et la performance en mati�re de recherche dans les institutions acad�miques nationales  et sous-r�gionales partenaires',
	'La qualit� de l''enseignement et de la recherche dans les institutions acad�miques partenaires est am�lior�e'
	),
	(null,
	'Financer la mobilit� des �tudiants ',
	null,
	'Janvier - D�cembre 2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'indicateur de performance indicateur de r�alisation',
	'Nbre d''�tudiants r�gionaux et nationaux ayant re�u un financement pour la mobilit� de recherche du CEA MITIC',
	'indicateur 1',
	'a uploader',
	'Partenariat ',
	'Contribuer � renforcer la performance en mati�re d''apprentissage et d''enseignement et la performance en mati�re de recherche dans les institutions acad�miques nationales  et sous-r�gionales partenaires',
	'La qualit� de l''enseignement et de la recherche dans les institutions acad�miques partenaires est am�lior�e'
	),
	(null,
	'G�rer la communication du CEA-MITIC: site web, inserts publicitaires, presse, d�pliants, etc.',
	null,
	'Janvier - D�cembre 2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'Indicateur de r�alisation',
	'les supports de communication du projets sont diffus�s (site web cr�� et visit�, ....',
	'les espaces de communication du site web CEA MITIC',
	'capture du site, vid�os et spots publicitaires mises en ligne',
	'Gestion et Gouvernance',
	'Assurer une gouvernance universitaire libre de toute influence avec des outils de suivi /�valuation qui am�liore la gestion',
	'Des outils de suivi et d''�valuation sont utilis�s'
	),
	(null,
	'Recruter un personnel d''appoin',
	null,
	'01/05/2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'Indicateur de r�alisation',
	'l''Assistante de direction et le Charg� du Suivi des �tudiants et du partenariat sont recrut�s',
	'Hors template',
	'a uploader',
	'Gestion et Gouvernance',
	'Assurer une gouvernance universitaire libre de toute influence avec des outils de suivi /�valuation qui am�liore la gestion',
	'Des outils de suivi et d''�valuation sont utilis�s'
	),
	(null,
	'Fonctionnement Unit� de gestion',
	null,
	'Janvier - D�cembre 2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'Indicateur de r�alisation',
	'le Nombre de r�unions de coordination de l''Unit� de Gestion',
	'indicateur 10',
	'CR r�unions de coordination de l''Unit� de Gestion du CEA MITIC',
	'Gestion et Gouvernance',
	'Assurer une gouvernance universitaire libre de toute influence avec des outils de suivi /�valuation qui am�liore la gestion',
	'Des outils de suivi et d''�valuation sont utilis�s'
	),
	(null,
	'Rencontres du comit� de pilotage',
	null,
	'Juin-Juillet 2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'Indicateur de performance',
	'le Nombre de rencontres du comit� de pilotage',
	'indicateur 10',
	'CR r�unions de coordination de l''Unit� de Gestion du CEA MITIC',
	'Gestion et Gouvernance',
	'Assurer une gouvernance universitaire libre de toute influence avec des outils de suivi /�valuation qui am�liore la gestion',
	'Des outils de suivi et d''�valuation sont utilis�s'
	),
	(null,
	'Mettre en place un conseil scientifique du CEA et assurer son fonctionnement (1 r�union annuelle)',
	null,
	'31/11/2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'Indicateur de performance',
	'la r�union annuelle du Comit� scientique',
	'indicateur 10',
	'CR r�unions de coordination de l''Unit� de Gestion du CEA MITIC',
	'Gestion et Gouvernance',
	'Assurer une gouvernance universitaire libre de toute influence avec des outils de suivi /�valuation qui am�liore la gestion',
	'Des outils de suivi et d''�valuation sont utilis�s'
	),
	(null,
	'Acqu�rir un v�hicule de liaison DkR-SL',
	null,
	'01/05/2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'Indicateur de r�alisation',
	'le v�hicule est acquis',
	'Hors template',
	'a uploader',
	'Gestion et Gouvernance',
	'Assurer une gouvernance universitaire libre de toute influence avec des outils de suivi /�valuation qui am�liore la gestion',
	'Des outils de suivi et d''�valuation sont utilis�s'
	),
	(null,
	'Acqu�rir un outil de suivi/�valuation et GF',
	null,
	'01/05/2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'Indicateur de r�alisation',
	'l''application de suivi -�valaution du CEA est con�u et mise � jour des donn�es',
	'Mise en ligne de l''application sur le site du CEA MITIC ',
	'a uploader',
	'Gestion et Gouvernance',
	'Assurer une gouvernance universitaire libre de toute influence avec des outils de suivi /�valuation qui am�liore la gestion',
	'Des outils de suivi et d''�valuation sont utilis�s'
	),
	(null,
	'Travaux de g�nie civil et �quipements',
	null,
	'Mai - D�cembre 2015',
	'calendrier annuel en Lien � pr�voir pour la saisie)',
	'Ex�cut�e',
	'Indicateur de r�alisation',
	'le si�ge du CEA MITIC est construit',
	'Hors template',
	'Le dossier de passation de march�  de construction et d''�quipements du Centre mise en ligne sur le site du CEA MITIC',
	'Gestion et Gouvernance',
	'Assurer une gouvernance universitaire libre de toute influence avec des outils de suivi /�valuation qui am�liore la gestion',
	'Des outils de suivi et d''�valuation sont utilis�s'
	);
