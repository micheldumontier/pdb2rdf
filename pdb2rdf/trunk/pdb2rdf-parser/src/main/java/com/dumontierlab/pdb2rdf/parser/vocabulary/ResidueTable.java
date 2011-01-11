/**
 * A one to one mapping between Amino acid and Nucleic acid residue symbols and their respective classes
 */
package com.dumontierlab.pdb2rdf.parser.vocabulary;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * @author Jose Cruz-Toledo
 * 
 */
public class ResidueTable {

	private static final Logger UNKNOWN_RESIDUE_LOG = Logger.getLogger("com.dumontierlab.pdb2rdf.unknown_residues");

	private static final Map<String, PdbOwlVocabulary.Class> symbol2class = new HashMap<String, PdbOwlVocabulary.Class>();
	private static final Map<String, String> class2symbol = new HashMap<String, String>();
	static {
		// amino acids first
		put("ALANINE", PdbOwlVocabulary.Class.Alanine);
		put("ARGININE", PdbOwlVocabulary.Class.Arginine);
		put("ASPARAGINE", PdbOwlVocabulary.Class.Asparagine);
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
		put("PROLINE", PdbOwlVocabulary.Class.Proline);
		put("SERINE", PdbOwlVocabulary.Class.Serine);
		put("THREONINE", PdbOwlVocabulary.Class.Threonine);
		put("TRYPTOPHAN", PdbOwlVocabulary.Class.Tryptophan);
		put("TYROSINE", PdbOwlVocabulary.Class.Tyrosine);
		put("VALINE", PdbOwlVocabulary.Class.Valine);
		put("SELENOCYSTEINE", PdbOwlVocabulary.Class.Selenocysteine);
		put("PYRROLYSINE", PdbOwlVocabulary.Class.Pyrrolysine);

		// Modified Amino acid residues
		put("D-GAMMA-GLUTAMYL-L-CYSTEINYLGLYCINE", PdbOwlVocabulary.Class.DGammaGlutamylLCysteinylGlycine);
		put("PHOSPHOSERINE", PdbOwlVocabulary.Class.PhosphoSerine);
		put("SELENOMETHIONINE", PdbOwlVocabulary.Class.SelenoMethionine);
		put("2-[(2S)-2-METHYLPYRROLIDIN-2-YL]-1H-BENZIMIDAZOLE-7-CARBOXAMIDE",
				PdbOwlVocabulary.Class.TwoTwoSTwoMethylPyrrolidinTwoYLOneHBenzimiazoleSevenCarboxamide);
		put("PHOSPHOTHREONINE", PdbOwlVocabulary.Class.PhosphoThreonine);
		put("PYROGLUTAMIC ACID", PdbOwlVocabulary.Class.PyroglutamicAcid);
		put("S-OXY CYSTEINE", PdbOwlVocabulary.Class.SOxyCysteine);
		put("2-AMINO-2-HYDROXYMETHYL-PROPANE-1,3-DIOL",
				PdbOwlVocabulary.Class.TwoAminoTwoHydroxyMethylPropaneOneThreeDiol);
		put("N-[[1-[N-ACETAMIDYL]-[1-CYCLOHEXYLMETHYL-2-HYDROXY-4-ISOPROPYL]-BUT-4-YL]-CARBONYL]-GLUTAMINYL-ARGINYL-AMIDE",
				PdbOwlVocabulary.Class.NOneNAcetamidylOneCyclohexymethylTwoHydroxyFourIsoPropylGlutaminylArginylAmide);
		put("3-CYCLOPENTYL-N-HYDROXYPROPANAMIDE", PdbOwlVocabulary.Class.ThreeCycloPentylNHydroxyPropanamide);

		// Nucleic acid residues
		put("CYTIDINE-5'-MONOPHOSPHATE", PdbOwlVocabulary.Class.CytidineFivePrimeMonophosphate);
		put("GUANOSINE-5'-MONOPHOSPHATE", PdbOwlVocabulary.Class.GuanosineFivePrimeMonophosphate);
		put("URIDINE-5'-MONOPHOSPHATE", PdbOwlVocabulary.Class.UridineFivePrimeMonophosphate);
		put("ADENOSINE-5'-MONOPHOSPHATE", PdbOwlVocabulary.Class.AdenosineFivePrimeMonophosphate);
		put("2'-DEOXYADENOSINE-5'-MONOPHOSPHATE", PdbOwlVocabulary.Class.TwoPrimeDeoxyAdenosineFivePrimeMonophosphate);
		put("2'-DEOXYGUANOSINE-5'-MONOPHOSPHATE", PdbOwlVocabulary.Class.TwoPrimeDeoxyGuanosineFivePrimeMonophosphate);
		put("2'-DEOXYCYTIDINE-5'-MONOPHOSPHATE", PdbOwlVocabulary.Class.TwoPrimeDeoxyCytidineFivePrimeMonophosphate);
		put("THYMIDINE-5'-MONOPHOSPHATE", PdbOwlVocabulary.Class.ThymidineFivePrimeMonophosphate);
		put("ADENINE", PdbOwlVocabulary.Class.Adenine);

		// Modified nucleic acid residues
		put("2'-DEOXYINOSINE-5'-MONOPHOSPHATE", PdbOwlVocabulary.Class.TwoPrimeDeoxyinosine5PrimeMonophosphate);
		put("5-BROMO-2'-DEOXY-CYTIDINE-5'-MONOPHOSPHATE",
				PdbOwlVocabulary.Class.FivePrimeBromo2PrimeDeoxyCytidineFivePrimeMonophosphate);
		put("(1R)-1,4-ANHYDRO-2-DEOXY-1-(3-FLUOROPHENYL)-5-O-PHOSPHONO-D-ERYTHRO-PENTITOL",
				PdbOwlVocabulary.Class.OneROneFourAnhydroTwoDeoxyOneThreeFluoroPhenylFiveOPhosphonoDErythroPentinol);
		put("5-METHYL-2'-DEOXY-CYTIDINE-5'-MONOPHOSPHATE",
				PdbOwlVocabulary.Class.FiveMethylTwoPrimeDeoxyCytidineFivePrimeMonophosphate);
		put("GALACTOSE-URIDINE-5'-DIPHOSPHATE", PdbOwlVocabulary.Class.GalactoseUridineFivePrimeDiphosphate);
		put("ADENOSINE-5'-TRIPHOSPHATE", PdbOwlVocabulary.Class.AdenosineFivePrimeTriPhosphate);
		put("NICOTINAMIDE-ADENINE-DINUCLEOTIDE", PdbOwlVocabulary.Class.NicotinamideAdenineDinucleotide);
		put("NADP NICOTINAMIDE-ADENINE-DINUCLEOTIDE PHOSPHATE",
				PdbOwlVocabulary.Class.NapdNicotinamideAdenineDinucleotidePhosphate);
		put("FLAVIN MONONUCLEOTIDE", PdbOwlVocabulary.Class.FlavinMononucleotide);
		put("GUANOSINE-5'-DIPHOSPHATE", PdbOwlVocabulary.Class.GuanosineFivePrimeDiphosphate);

		// Ions
		put("CHLORIDE ION", PdbOwlVocabulary.Class.ChlorideIon);
		put("MANGANESE (II) ION", PdbOwlVocabulary.Class.ManganeseIonII);
		put("MAGNESIUM ION", PdbOwlVocabulary.Class.MagnesiumIon);
		put("POTASSIUM ION", PdbOwlVocabulary.Class.PotassiumIon);
		put("SODIUM ION", PdbOwlVocabulary.Class.SodiumIon);
		put("CALCIUM ION", PdbOwlVocabulary.Class.CalciumIon);
		put("SULFATE ION", PdbOwlVocabulary.Class.SulfateIon);
		put("FE (III) ION", PdbOwlVocabulary.Class.FeIIIIon);
		put("NICKEL (II) ION", PdbOwlVocabulary.Class.NickelIIIon);
		put("ZINC ION", PdbOwlVocabulary.Class.ZincIon);
		put("HYPOPHOSPHITE", PdbOwlVocabulary.Class.HypoPhosphite);

		// other stuff
		put("[4R-(4ALPHA,5ALPHA,6BETA,7BETA)]-3,3'-[[TETRAHYDRO-5,6-DIHYDROXY-2-OXO-4,7-BIS(PHENYLMETHYL)-1H-1,3-DIAZEPINE-1,3(2H)-DIYL] BIS(METHYLENE)]BIS[N-2-THIAZOLYLBENZAMIDE]",
				PdbOwlVocabulary.Class.FourRFourAlphaThiazolyBenzamide);
		put("PROTOPORPHYRIN IX CONTAINING FE", PdbOwlVocabulary.Class.ProtoporphyrinIxContainingFe);
		put("AMINO GROUP", PdbOwlVocabulary.Class.AminoGroup);
		put("IRON/SULFUR CLUSTER", PdbOwlVocabulary.Class.IronSulfurCluster);
		put("N-ACETYL-D-GLUCOSAMINE", PdbOwlVocabulary.Class.NAcetylDGlucosamine);
		put("2-HYDROXYMETHYL-6-OCTYLSULFANYL-TETRAHYDRO-PYRAN-3,4,5-TRIOL",
				PdbOwlVocabulary.Class.TwoHydroxymethylSixOctylsulfanylTetrahydroPyranThreeFourFiveTriol);
		put("ARACHIDONIC ACID", PdbOwlVocabulary.Class.ArachidonicAcid);
		put("OLEIC ACID", PdbOwlVocabulary.Class.OleicAcid);
		put("GLYCEROL", PdbOwlVocabulary.Class.Glycerol);
		put("WATER", PdbOwlVocabulary.Class.Water);
		put("UNKNOWN", PdbOwlVocabulary.Class.UnknownResidue);

	}

	public static PdbOwlVocabulary.Class get(String typeSymbol) {
		PdbOwlVocabulary.Class c = symbol2class.get(typeSymbol.toUpperCase());
		if (c == null) {
			UNKNOWN_RESIDUE_LOG.warn("Unknown residue type: " + typeSymbol);
		}
		return c;
	}

	private static String getSymbol(String residueClassUri) {
		String symbol = class2symbol.get(residueClassUri);
		assert symbol != null : "No Residue class" + residueClassUri;
		return symbol;
	}

	private static void put(String symbol, PdbOwlVocabulary.Class residueClass) {
		symbol2class.put(symbol, residueClass);
		class2symbol.put(residueClass.uri(), symbol);
	}
}
