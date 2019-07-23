/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingnetcdffile;

import java.io.File;
import java.io.IOException;
import java.util.List;
//import ucar.netcdf.NetcdfFile;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;


/**
 *
 * @author loren
 */
public class ReadingNetCdfFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Variable[] attributeNetCDF;
        attributeNetCDF = getInfo();
        
        for(int i=0; i<attributeNetCDF.length; i++)
        {
            if(attributeNetCDF[i]!=null)
                System.out.println(attributeNetCDF[i]);
        }
        
    }
    
    
    public static Variable[] getInfo() throws IOException {
	String fileName = "format.nc3";
	NetcdfFile ncFile = null;
	Variable[] attributeNetCDF;
        int cont=0;
	try {
		ncFile = NetcdfFile.open(fileName);
	} catch(java.lang.IllegalArgumentException ex) {
		IOException e = new IOException("Not a netcdf file");
		e.fillInStackTrace();
		throw e;
	}
        
	List<?> globalAttList = ncFile.getGlobalAttributes();
	attributeNetCDF = new Variable[globalAttList.size()];
        
        Variable lat = ncFile.findVariable("lat");
        attributeNetCDF[cont] = lat;
        
        cont++;
        
        Variable lon = ncFile.findVariable("lon");
        attributeNetCDF[cont] = lon;
//        System.out.println(v);
        
        /*
	for(int i=0; i < globalAttList.size(); i++ ) {
		attributeNetCDF[i] = globalAttList.get(i).toString();
	}*/
	return attributeNetCDF;
}
 
    
}
