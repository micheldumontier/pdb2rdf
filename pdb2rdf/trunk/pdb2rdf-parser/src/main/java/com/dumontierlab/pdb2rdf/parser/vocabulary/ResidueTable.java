/**
 * A one to one mapping between Amino acid and Nucleic acid residue symbols and their respective classes
 */
package com.dumontierlab.pdb2rdf.parser.vocabulary;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jose Cruz-Toledo
 * 
 */
public class ResidueTable {
	private static final Map<String, PdbOwlVocabulary.Class> symbol2class =new HashMap<String,PdbOwlVocabulary.Class>();
	private static final Map<String, String> class2symbol = new HashMap<String, String>();
	static{
		//amino acids first
		put("ALANINE", PdbOwlVocabulary.Class.Alanine);
		put("ARGININE", PdbOwlVocabulary.Class.Arginine);
		put("ASPARAGINE",PdbOwlVocabulary.Class.Asparagine);
		put("ASPARTIC ACID", PdbOwlVocabulary.Class.AsparticAcid);
		put("CYSTEINE", PdbOwlVocabulary.Class.Cysteine);
		put("GLUTAMIC ACID", PdbOwlVocabulary.Class.GlutamicAcid);
		put("GLUTAMINE", PdbOwlVocabulary.Class.Glutamine);
		put("GLYCINE", PdbOwlVocabulary.Class.Glycine);
		put("HISTIDINE", PdbOwlVocabulary.Class.Histidine);
		put("ISOLEUCINE", PdbOwlVocabulary.Class.Isoleucine);
		put("LEUCINE", PdbOwlVocabulary.Class.Leucine);
		put("LYSINE", PdbOwlVocabulary.Class.Lysine);
		put("METHIONINE", PdbOwlVocabulary.Class.Methionine);
		put("PHENYLALANINE", PdbOwlVocabulary.Class.Phenylalanine);
		put("PROLINE",PdbOwlVocabulary.Class.Proline);
		put("SERINE", PdbOwlVocabulary.Class.Serine);
		put("THREONINE", PdbOwlVocabulary.Class.Threonine);
		put("TRYPTOPHAN",PdbOwlVocabulary.Class.Tryptophan);
		put("TYROSINE", PdbOwlVocabulary.Class.Tyrosine);
		put("VALINE", PdbOwlVocabulary.Class.Valine);
		put("SELENOCYSTEINE", PdbOwlVocabulary.Class.Selenocysteine);
		put("PYRROLYSINE", PdbOwlVocabulary.Class.Pyrrolysine);
		put("CYTIDINE-5&apos;-MONOPHOSPHATE", PdbOwlVocabulary.Class.CytidineFivePrimeMonophosphate);
		put("GUANOSINE-5&apos;-MONOPHOSPHATE", PdbOwlVocabulary.Class.GuanosineFivePrimeMonophosphate);
		put("URIDINE-5&apos;-MONOPHOSPHATE",PdbOwlVocabulary.Class.UridineFivePrimeMonophosphate);
		put("ADENOSINE-5&apos;-MONOPHOSPHATE",PdbOwlVocabulary.Class.AdenosineFivePrimeMonophosphate);
		put("2P-DEOXYADENOSINE-5P-MONOPHOSPHATE", PdbOwlVocabulary.Class.TwoPrimeDeoxyAdenosineFivePrimeMonophosphate);
		put("2&apos;-DEOXYGUANOSINE-5&apos;-MONOPHOSPHATE", PdbOwlVocabulary.Class.TwoPrimeDeoxyGuanosineFivePrimeMonophosphate);
		put("THYMIDINE-5&apos;-MONOPHOSPHATE", PdbOwlVocabulary.Class.ThymidineFivePrimeMonophosphate);
	}
	
	public static PdbOwlVocabulary.Class get(String typeSymbol){
		PdbOwlVocabulary.Class c = symbol2class.get(typeSymbol.toUpperCase());
		assert c != null: "Unknown residue type symbol " + typeSymbol;
		return c;
	}
	
	private static String getSymbol(String residueClassUri){
		String symbol = class2symbol.get(residueClassUri);
		assert symbol != null : "No Residue class"+residueClassUri;
		return symbol;
	}
	
	private static void put(String symbol, PdbOwlVocabulary.Class residueClass){
		symbol2class.put(symbol, residueClass);
		class2symbol.put(residueClass.uri(), symbol);
	}
}
