#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Dentiste
#------------------------------------------------------------

CREATE TABLE Dentiste(
        id          Int NOT NULL ,
        first_name  Varchar (25) ,
        last_name   Varchar (25) ,
        email       Varchar (100) ,
        gender      Bool ,
        speciality  Int ,
        address     Varchar (100) ,
        city        Varchar (25) ,
        phone       BigInt ,
        image       Varchar (500) ,
        id_openings Int ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: openings
#------------------------------------------------------------

CREATE TABLE openings(
        id                Int NOT NULL ,
        lundiOuverture    Int ,
        lundiFermeture    Int ,
        mardiOuverture    Int ,
        mardiFermeture    Int ,
        mercrediOuverture Int ,
        mercrediFermeture Int ,
        jeudiOuverture    Int ,
        jeudiFermeture    Int ,
        vendrediOuverture Int ,
        vendrediFermeture Int ,
        id_Dentiste       Int ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: users
#------------------------------------------------------------

CREATE TABLE users(
        id       int (11) Auto_increment  NOT NULL ,
        login    Varchar (25) ,
        password Varchar (50) ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: relation1
#------------------------------------------------------------

CREATE TABLE relation1(
        id       Int NOT NULL ,
        id_users Int NOT NULL ,
        PRIMARY KEY (id ,id_users )
)ENGINE=InnoDB;

ALTER TABLE Dentiste ADD CONSTRAINT FK_Dentiste_id_openings FOREIGN KEY (id_openings) REFERENCES openings(id);
ALTER TABLE openings ADD CONSTRAINT FK_openings_id_Dentiste FOREIGN KEY (id_Dentiste) REFERENCES Dentiste(id);
ALTER TABLE relation1 ADD CONSTRAINT FK_relation1_id FOREIGN KEY (id) REFERENCES Dentiste(id);
ALTER TABLE relation1 ADD CONSTRAINT FK_relation1_id_users FOREIGN KEY (id_users) REFERENCES users(id);
