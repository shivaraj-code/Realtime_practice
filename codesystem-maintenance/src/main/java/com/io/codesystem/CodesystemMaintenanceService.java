package com.io.codesystem;

public abstract class CodesystemMaintenanceService {
	
	
	public abstract void fileUploading(String filePath);

    public abstract void fileProcessing();

    public abstract void analysis();

    public abstract void synching();

    public abstract void verification();

    public abstract void complete();

}
