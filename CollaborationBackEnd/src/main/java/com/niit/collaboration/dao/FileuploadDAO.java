package com.niit.collaboration.dao;

import com.niit.collaboration.model.Fileupload;

public interface FileuploadDAO {
	
		void save(Fileupload fileupload);
		Fileupload getFile(String username);
	}


