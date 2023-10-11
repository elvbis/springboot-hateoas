  CREATE TABLE IF NOT EXISTS person_entity
   (id VARCHAR(4) PRIMARY KEY,
	first_name VARCHAR(60),
	last_name VARCHAR(60),
	STATUS NUMERIC(1,0) DEFAULT 1 ,
	AUD_CREATED_DATE TIMESTAMP 	,
	AUD_CREATED_USER VARCHAR(120 ) ,
	AUD_UPDATE_DATE TIMESTAMP		,
	AUD_UPDATE_USER VARCHAR(120 )
   );

   COMMENT ON COLUMN person_entity.id IS 'Identificador de la tabla de 4 caracteres númericos';
   COMMENT ON COLUMN person_entity.first_name IS 'Denominación del los documentos de identidad';
   COMMENT ON COLUMN person_entity.last_name IS 'Denominación del los documentos de identidad';
   COMMENT ON TABLE  person_entity  IS 'La tabla Identidad contiene el ID';
