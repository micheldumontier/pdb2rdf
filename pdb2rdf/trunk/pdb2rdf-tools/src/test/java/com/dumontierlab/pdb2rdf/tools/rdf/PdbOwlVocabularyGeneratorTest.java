package com.dumontierlab.pdb2rdf.tools.rdf;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.dumontierlab.pdb2rdf.util.UriUtil;


public class PdbOwlVocabularyGeneratorTest {
	@Test
	public void x(){
		PdbOwlVocabularyGenerator p = new PdbOwlVocabularyGenerator(new File("/tmp/input.txt"));
		HashMap<String, String> hm = PdbOwlVocabularyGenerator.getResidueMap(new File("/tmp/input.txt"));
		
		Iterator<String> it = hm.keySet().iterator();
		String str1="";
		String str2="";
		while(it.hasNext()){
			String key = it.next();
			str1+=key+"(DEFAULT_NAMESPACE+\""+ UriUtil.urlEncode(UriUtil.replacePrimes(UriUtil.toCamelCase(hm.get(key))))+"\"),\n";
		}
		
		
		Iterator<String> it2 = hm.keySet().iterator();
		while(it2.hasNext()){
			String key = it2.next();
			str2+="put(\""+hm.get(key)+"\", PdbOwlVocabulary.Class."+key+");\n";
		}
		
		try {
			FileUtils.writeStringToFile(new File("/tmp/bunbun.bun"), str1);
			FileUtils.writeStringToFile(new File("/tmp/bunbun2.bun"), str2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
