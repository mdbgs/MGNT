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
   pseudo               varchar(100)                    not null,
   password             varchar(500)                    not null,
   dateinscription            datetime                    default null,
   photo				VARCHAR(500) 							  null,
   constraint PK_COMPTE primary key clustered (pseudo),
   constraint AK_IDETUDIANT_ENSEIGNA unique (pseudo)
);

/*==============================================================*/
/* Table : Enseignant                                           */
/*==============================================================*/
create table Enseignant 
(
   iDEnseignat          integer                        not null AUTO_INCREMENT,
   pseudo             varchar(100)                    not null,
   nom                  varchar(100)                   null,
   prenom               varchar(100)                   null,
   niveau               varchar(100)                   null,
   nationalite          varchar(100)                   null,
   adresse              varchar(500)                   null,
   email                varchar(100)                   null,
   telephone            varchar(100)                   null,
   bp                   varchar(100)                   null,
   sexe                 integer                        null,
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
   pseudo             varchar(100)                    not null,
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
   numeroEtudiant       varchar(100)                   null ,
   pacNom               varchar(100)                   null,
   pacPrenom            varchar(100)                   null,
   pacTel               varchar(100)                   null,
   pacAdresse           varchar(100)                   null,
   programme            varchar(100)                        null,
   semestre             varchar(100)                        null,
   constraint PK_ETUDIANT primary key (iDEtudiant),
   constraint AK_IDEtudiant unique (iDEtudiant),
   constraint AK_NumEtudiant unique (numeroEtudiant)
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
   pseudo             varchar(100)                    not null,
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
   nomJournal           varchar(250)                   null,
   auteurs              varchar(255)                   null,
   impactFactor         varchar(255)                   null,
   typePublication         varchar(255)                   null,
   nomFichier         varchar(255)                   null,
   constraint PK_PUBLICATION primary key (iDpublication)
);

/*==============================================================*/
/* Table : Responsable                                          */
/*==============================================================*/
create table Responsable 
(
   iDResponsable        integer                        not null AUTO_INCREMENT,
   pseudo             varchar(100)                    not null,
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
pseudo varchar(100)                    not null,
rolename varchar(120) NOT NULL,
PRIMARY KEY (pseudo, rolename),
CONSTRAINT users_roles_fk1 FOREIGN KEY (pseudo) REFERENCES compte (pseudo),
CONSTRAINT users_roles_fk2 FOREIGN KEY (rolename) REFERENCES roles (rolename)
);


/*==============================================================*/
/* Table : activiteResponsable                                  */
/*==============================================================*/
create table activiteResponsable 
(
   iDResponsable        integer                        not null ,
   IDactivite         integer                        not null,
   constraint PK_ACTIVITERESPONSABLE primary key clustered (iDResponsable, IDactivite)
);


/*==============================================================*/
/* Table : enseignantFormation                                  */
/*==============================================================*/
create table enseignantFormation 
(
   iDEnseignat          integer                        not null,
   IDFormation          integer                        not null,
   constraint PK_ENSEIGNANTFORMATION primary key clustered (iDEnseignat, IDFormation)
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
/* Table : Indicateur                                   */
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
	(null,1,'SUIVI DES INSCRIPTIONS DES ÉTUDIANTS DU CEA','Regionalité','SIEC'),
	(null,2,'SUIVI DES PROGRAMMES DU CEA','Qualité de la formation','SPC'),
	(null,3,'SUIVI DES STAGES','Sensibilisation','SDS'),
	(null,5,'SUIVI DE LA FORMATION DES ENSEIGNANTS','Qualité de la formation','SFE'),
	(null,6,'SUIVI DES PROGRAMMES NOUVELLEMENT CREES OU REVISES','Qualité de la formation','SPNCR'),
	(null,9,'SUIVI DES PARTENARIATS','Sensibilisation/Régionalité','SDP'),
	(null,10,'SUIVI DES REUNIONS','Administration / Gouvernance Qualité FM','SDR');
alter table Animateur_Relecteur
   add constraint FK_ANIMATEU_PARTENAIR_PARTENAI foreign key (iDpartenaire)
      references Partenaires (iDpartenaire)
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

alter table activiteResponsable
   add constraint FK_ACTIVITE_ACTIVITER_ACTIVITE foreign key (IDactivite)
      references Activite (IDactivite)
      on update cascade
      on delete cascade;

alter table activiteResponsable
   add constraint FK_ACTIVITE_ACTIVITER_RESPONSA foreign key (iDResponsable)
      references Responsable (iDResponsable)
      on update cascade
      on delete cascade;

alter table enseignantFormation
   add constraint FK_ENSEIGNA_ENSEIGNAN_ENSEIGNA foreign key (iDEnseignat)
      references Enseignant (iDEnseignat)
      on update cascade
      on delete cascade;

alter table enseignantFormation
   add constraint FK_ENSEIGNA_ENSEIGNAN_FORMATIO foreign key (IDFormation)
      references Formation (IDFormation)
      on update cascade
      on delete cascade;
      
/*Insertion des comptes d'utilisateur de la plateforme */
insert into compte values('m.sall','ceamitic2016',2016/04/04,'');
insert into compte values('mme.sy','ceamitic2016',2016/04/04,'');
insert into compte values('mlle.thiam','ceamitic2016',2016/04/04,'');
insert into compte values('m.dembele','ceamitic2016',2016/04/04,'');
insert into compte values('m.lo','ceamitic2016',2016/04/04,'');
insert into compte values('m.diop','ceamitic2016',2016/04/04,'');
insert into compte values('m.ndiaye','ceamitic2016',2016/04/04,'');
insert into compte values('ucad','ceamitic2016',2016/04/04,'');
insert into compte values('woldBank','ceamitic2016',2016/04/04,'');
insert into compte values('m.maiga','ceamitic2016',2016/04/04,'');
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
INSERT INTO users_roles  VALUES ('woldBank', 'BanqueMondial');
INSERT INTO users_roles  VALUES ('m.maiga', 'viceCoordonnateur');
INSERT INTO users_roles  VALUES ('mlle.thiam', 'etudiant');

INSERT INTO Activite VALUES
	(null,
	'Renforcer les formations de master et doctorales existantes  ( Recruter professeurs invités et membres de jury de thèse, chercheurs instituts de recherche)',
	null,
	'Mai - Décembre 2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'Indicateur de réalisation',
	'le nombre de professeurs, de membres de jury de thèse et invités',
	'Hors template',
	'a uploader','Excellence en apprentissage','Atteindre l’excellence de la formation  en STEM à travers la promotion des STEM, l’innovation pédagogique, l’amélioration du plateau technique et la promotion de la qualité.',' La qualité de l''enseignement et de l''apprentissage est améliorée'
	),
	(null,
	'Faire participer les professionnels dans la formation',
	null,
	'Mai - Décembre 2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'Indicateur de réalisation',
	'le nombre de professionnels ( de chercheurs d''insttuts) intervenants dans les formations',
	'Hors template',
	'a uploader',
	'Excellence en apprentissage',
	'Atteindre l’excellence de la formation  en STEM à travers la promotion des STEM, l’innovation pédagogique, l’amélioration du plateau technique et la promotion de la qualité.',
	' La qualité de l''enseignement et de l''apprentissage est améliorée'
	),
	(null,
	'Former les enseignants à l''approche par compétence ',
	null,
	'Juin-Décembre 2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'Indicateur de performance',
	'Nombre de PER (nationaux et régionaux formés par le CEA',
	'indicateur 5',
	'a uploader',
	'Excellence en apprentissage',
	'Atteindre l’excellence de la formation  en STEM à travers la promotion des STEM, l’innovation pédagogique, l’amélioration du plateau technique et la promotion de la qualité.',
	' La qualité de l''enseignement et de l''apprentissage est améliorée'
	),
	(null,
	'Elaborer les programmes de Master (révisés et nouveaux)',
	null,
	'Juin-Juillet 2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'Indicateur de performance',
	'Nombre de Master révisés / créés',
	'Hors template',
	'a uploader',
	'Excellence en apprentissage',
	'Atteindre l’excellence de la formation  en STEM à travers la promotion des STEM, l’innovation pédagogique, l’amélioration du plateau technique et la promotion de la qualité.',
	' La qualité de l''enseignement et de l''apprentissage est améliorée'
	),
	(null,
	'Accompagner la recherche des stages de fin d’études pour les étudiants dans les entreprises et centres de recherche',
	null,
	'Janvier -Décembre 2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'Indicateur de performance',
	'Nombre d''étudiants et de professeurs en stage pendant au moins 1 mois',
	'indicateur 3',
	'a uploader',
	'Excellence en apprentissage',
	'Atteindre l’excellence de la formation  en STEM à travers la promotion des STEM, l’innovation pédagogique, l’amélioration du plateau technique et la promotion de la qualité.',
	' La qualité de l''enseignement et de l''apprentissage est améliorée'
	),
	(null,
	'Organiser des activités de sensibilisation (forums, olympiades, salons, séminaires de formation des formateurs) et d’orientation dans les différents domaines des STEM',
	null,
	'Janvier -Décembre 2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'Indicateur de réalisation',
	'Tx de participation (eleves, enseignants, etc.)',
	'Hors template',
	'a uploader',
	'Excellence en apprentissage',
	'Atteindre l’excellence de la formation  en STEM à travers la promotion des STEM, l’innovation pédagogique, l’amélioration du plateau technique et la promotion de la qualité.',
	' La qualité de l''enseignement et de l''apprentissage est améliorée'
	),
	(null,
	'Mettre à niveau les étudiants de Master et Doctorat via des FOAD en anglais',
	null,
	'Mai - Décembre 2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'indicateur de réalisation et indicateur de performance ',
	'Nombre d''étudiants régionaux et nationaux inscrits au Master, PHD, short courses',
	'indicateur 1',
	'a uploader',
	'Excellence en apprentissage',
	'Atteindre l’excellence de la formation  en STEM à travers la promotion des STEM, l’innovation pédagogique, l’amélioration du plateau technique et la promotion de la qualité.',
	' La qualité de l''enseignement et de l''apprentissage est améliorée'
	),
	(null,
	'Financer des Projets de recherche',
	null,
	'JAnvier - Décembre 2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'Indicateur de réalisation',
	'Nombre de chercheurs  régionaux et nationaux ayant recu un financement de projet de recherche par le CEA MITIC',
	'Hors template',
	'a uploader',
	'Excellence dans la recherche',
	'Créer les conditions et l’environnement pour une recherche de qualité en Mathématiques, Informatique et TI',
	'Le Nombre de doctorants dans les STEMS et le taux d''encadrement doctoral sont améliorés'
	),
	(null,
	'Financer les Bourses doctorales (hors projets)',
	null,
	'Janvier - Décembre 2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'Nbre d''étudiants régionaux et nationaux ayant reçu une bourse doctorale du CEA MITIC',
	'le nombre de professionnels ( de chercheurs d''insttuts) intervenants dans les formations',
	'indicateur 1',
	'a uploader',
	'Excellence dans la recherche',
	'Créer les conditions et l’environnement pour une recherche de qualité en Mathématiques, Informatique et TI',
	'Le Nombre de doctorants dans les STEMS et le taux d''encadrement doctoral sont améliorés'
	),
	(null,
	'Financer la Mobilité de recherches',
	null,
	'Janvier - Décembre 2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'Indicateur de réalisation',
	'Nombre de chercheurs régionaux et nationaux ayant reçu un financement pour la mobilité de recherche du CEA MITIC',
	'Hors template',
	'a uploader',
	'Excellence dans la recherche',
	'Créer les conditions et l’environnement pour une recherche de qualité en Mathématiques, Informatique et TI',
	'Le Nombre de doctorants dans les STEMS et le taux d''encadrement doctoral sont améliorés'
	),
	(null,
	'Soutenir les  publications scientifiques',
	null,
	'Janvier - Décembre 2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'indicateur de performance indicateur de réalisation',
	'Nombre de publications scientifiques (nationales et internationales) ayant été soutenues par le CEA MITIC',
	'indicateur 7',
	'voir template tableau indicateur 7',
	'Excellence dans la recherche',
	'Créer les conditions et l’environnement pour une recherche de qualité en Mathématiques, Informatique et TI',
	'Le Nombre de doctorants dans les STEMS et le taux d''encadrement doctoral sont améliorés'
	),
	(null,
	'Organiser et participer à des  conférences internationales',
	null,
	'Janvier - Décembre 2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'Indicateur de réalisation',
	'Nombre chercheurs et de partenaires ayant organisé et participé à des conférences internationales',
	'Hors template',
	'a uploader',
	'Excellence dans la recherche',
	'Créer les conditions et l’environnement pour une recherche de qualité en Mathématiques, Informatique et TI',
	'Le Nombre de doctorants dans les STEMS et le taux d''encadrement doctoral sont améliorés'
	),
	(null,
	'Mettre en place des programmes de bourses d’excellence (meilleurs étudiants, filles, etc.)',
	null,
	'Mai - Décembre 2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'indicateur de performance indicateur de réalisation',
	'Nbre d''étudiants régionaux et nationaux ayant reçu une bourse d''excellence du CEA MITIC',
	'indicateur 1',
	'a uploader',
	'Partenariat ',
	'Devenir le Centre STEM de convergences préféré des professeurs et étudiants au niveau régional',
	'Le nombre d’étudiants, d’enseignants-chercheurs et chercheurs au niveau régional séjournant au CEA accru'
	),
	(null,
	'Mener des missions de sensibilisation/marketing et vulgarisation dans la sous-région',
	null,
	'Juillet-Octobre 2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'indicateur de performance indicateur de réalisation',
	'Nombre de conventions signés avec les partenaires régionaux Nombre de rencontres /missions effectuées dans la sous région',
	'indicateur 9%indicateur 10',
	'Conventions signées CR Missions ou rencontres avec les partenaires',
	'Partenariat ',
	'Devenir le Centre STEM de convergences préféré des professeurs et étudiants au niveau régional',
	'Le nombre d’étudiants, d’enseignants-chercheurs et chercheurs au niveau régional séjournant au CEA accru'
	),
	(null,
	'Rencontrer les partenaires nationaux (académiques et industriels)',
	null,
	'Janvier - Décembre 2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'Rencontrer les partenaires nationaux (académiques et industriels)',
	'Nombre de conventions signés avec les partenaires académiques et industriels nationaux Nombre de rencontres /missions effectuées au Sénégal',
	'indicateur 9%indicateur 10',
	'a uploader',
	'Partenariat ',
	'Contribuer à renforcer la performance en matière d’apprentissage et d’enseignement et la performance en matière de recherche dans les institutions académiques nationales  et sous-régionales partenaires',
	'La qualité de l’enseignement et de la recherche dans les institutions académiques partenaires est améliorée'
	),
	(null,
	'Conduire et appuyer des missions d’enseignement et de recherche dans les institutions partenaires',
	null,
	'Janvier - Décembre 2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'Indicateur de réalisation',
	'Nombre de  missions d''enseignement et de recherche effectués dans les institutions partenaires partenaires',
	'Hors template',
	'a uploader',
	'Partenariat ',
	'Contribuer à renforcer la performance en matière d’apprentissage et d’enseignement et la performance en matière de recherche dans les institutions académiques nationales  et sous-régionales partenaires',
	'La qualité de l’enseignement et de la recherche dans les institutions académiques partenaires est améliorée'
	),
	(null,
	'Financer la mobilité des étudiants ',
	null,
	'Janvier - Décembre 2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'indicateur de performance indicateur de réalisation',
	'Nbre d''étudiants régionaux et nationaux ayant reçu un financement pour la mobilité de recherche du CEA MITIC',
	'indicateur 1',
	'a uploader',
	'Partenariat ',
	'Contribuer à renforcer la performance en matière d’apprentissage et d’enseignement et la performance en matière de recherche dans les institutions académiques nationales  et sous-régionales partenaires',
	'La qualité de l’enseignement et de la recherche dans les institutions académiques partenaires est améliorée'
	),
	(null,
	'Gérer la communication du CEA-MITIC : site web, inserts publicitaires, presse, dépliants, etc.',
	null,
	'Janvier - Décembre 2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'Indicateur de réalisation',
	'les supports de communication du projets sont diffusés (site web créé et visité, ….',
	'les espaces de communication du site web CEA MITIC',
	'capture du site, vidéos et spots publicitaires mises en ligne',
	'Gestion et Gouvernance',
	'Assurer une gouvernance universitaire libre de toute influence avec des outils de suivi /évaluation qui améliore la gestion',
	'Des outils de suivi et d''évaluation sont utilisés'
	),
	(null,
	'Recruter un personnel d''appoin',
	null,
	'01/05/2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'Indicateur de réalisation',
	'l''Assistante de direction et le Chargé du Suivi des étudiants et du partenariat sont recrutés',
	'Hors template',
	'a uploader',
	'Gestion et Gouvernance',
	'Assurer une gouvernance universitaire libre de toute influence avec des outils de suivi /évaluation qui améliore la gestion',
	'Des outils de suivi et d''évaluation sont utilisés'
	),
	(null,
	'Fonctionnement Unité de gestion',
	null,
	'Janvier - Décembre 2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'Indicateur de réalisation',
	'le Nombre de réunions de coordination de l''Unité de Gestion',
	'indicateur 10',
	'CR réunions de coordination de l''Unité de Gestion du CEA MITIC',
	'Gestion et Gouvernance',
	'Assurer une gouvernance universitaire libre de toute influence avec des outils de suivi /évaluation qui améliore la gestion',
	'Des outils de suivi et d''évaluation sont utilisés'
	),
	(null,
	'Rencontres du comité de pilotage',
	null,
	'Juin-Juillet 2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'Indicateur de performance',
	'le Nombre de rencontres du comité de pilotage',
	'indicateur 10',
	'CR réunions de coordination de l''Unité de Gestion du CEA MITIC',
	'Gestion et Gouvernance',
	'Assurer une gouvernance universitaire libre de toute influence avec des outils de suivi /évaluation qui améliore la gestion',
	'Des outils de suivi et d''évaluation sont utilisés'
	),
	(null,
	'Mettre en place un conseil scientifique du CEA et assurer son fonctionnement (1 réunion annuelle)',
	null,
	'31/11/2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'Indicateur de performance',
	'la réunion annuelle du Comité scientique',
	'indicateur 10',
	'CR réunions de coordination de l''Unité de Gestion du CEA MITIC',
	'Gestion et Gouvernance',
	'Assurer une gouvernance universitaire libre de toute influence avec des outils de suivi /évaluation qui améliore la gestion',
	'Des outils de suivi et d''évaluation sont utilisés'
	),
	(null,
	'Acquérir un véhicule de liaison DkR-SL',
	null,
	'01/05/2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'Indicateur de réalisation',
	'le véhicule est acquis',
	'Hors template',
	'a uploader',
	'Gestion et Gouvernance',
	'Assurer une gouvernance universitaire libre de toute influence avec des outils de suivi /évaluation qui améliore la gestion',
	'Des outils de suivi et d''évaluation sont utilisés'
	),
	(null,
	'Acquérir un outil de suivi/évaluation et GF',
	null,
	'01/05/2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'Indicateur de réalisation',
	'l''application de suivi -évalaution du CEA est conçu et mise à jour des données',
	'Mise en ligne de l''application sur le site du CEA MITIC ',
	'a uploader',
	'Gestion et Gouvernance',
	'Assurer une gouvernance universitaire libre de toute influence avec des outils de suivi /évaluation qui améliore la gestion',
	'Des outils de suivi et d''évaluation sont utilisés'
	),
	(null,
	'Travaux de génie civil et équipements',
	null,
	'Mai - Décembre 2015',
	'calendrier annuel en Lien à prévoir pour la saisie)',
	'Exécutée',
	'Indicateur de réalisation',
	'le siège du CEA MITIC est construit',
	'Hors template',
	'Le dossier de passation de marché  de construction et d''équipements du Centre mise en ligne sur le site du CEA MITIC',
	'Gestion et Gouvernance',
	'Assurer une gouvernance universitaire libre de toute influence avec des outils de suivi /évaluation qui améliore la gestion',
	'Des outils de suivi et d''évaluation sont utilisés'
	);
