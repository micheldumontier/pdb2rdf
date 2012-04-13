/**Copyright (C) 2011  Jose Miguel Cruz Toledo 

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * 
 */
package com.dumontierlab.pdb2rdf.tools.chebi;

import uk.ac.ebi.webservices.chebi.ChebiWebServiceFault_Exception;
import uk.ac.ebi.webservices.chebi.ChebiWebServicePortType;
import uk.ac.ebi.webservices.chebi.ChebiWebServiceService;
import uk.ac.ebi.webservices.chebi.LiteEntity;
import uk.ac.ebi.webservices.chebi.LiteEntityList;
import uk.ac.ebi.webservices.chebi.SearchCategory;
import uk.ac.ebi.webservices.chebi.StarsCategory;

/**
 * @author "Jose Cruz-Toledo"
 * 
 */
public class ChebiSoapClient {
	private ChebiWebServicePortType port;

	private ChebiWebServicePortType getPort() {
		if (port == null) {
			ChebiWebServiceService service = new ChebiWebServiceService();
			port = service.getChebiWebServicePort();
		}
		return port;
	}

	/**
	 * Get the Chebi identifier corresponding to the parameter iupac name
	 * @param iupacName an iupac name
	 * @return a Chebi identifier CHEBI:12345
	 */
	public String getChebiId(String iupacName) {
		ChebiWebServicePortType aPort = getPort();
		try {
			LiteEntityList results = port.getLiteEntity(iupacName,
					SearchCategory.ALL_NAMES, 10, StarsCategory.ALL);
			if (results.getListElement().isEmpty()) {
				return null;
			} else {
				for (LiteEntity entity : results.getListElement()) {
					if (entity.getChebiAsciiName().equalsIgnoreCase(iupacName)) {
						return entity.getChebiId();
					}
				}
			}

		} catch (ChebiWebServiceFault_Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
}
