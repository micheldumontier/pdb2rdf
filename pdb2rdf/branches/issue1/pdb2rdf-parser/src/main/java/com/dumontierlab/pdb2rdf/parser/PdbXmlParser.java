/**
 * Copyright (c) 2009 Dumontierlab
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.dumontierlab.pdb2rdf.parser;

import java.io.IOException;

import org.xml.sax.SAXException;

import com.dumontierlab.pdb2rdf.model.PdbRdfModel;
import com.hp.hpl.jena.rdf.model.Model;

/**
 * @author Alexander De Leon
 */
public class PdbXmlParser extends AbstractPdbXmlParser {

	@Override
	protected ContentHandlerState getContentHandler(PdbRdfModel model) {
		return new PdbXmlContentHandler(model);
	}

	public static void main(String[] args) throws IOException, SAXException {
		Model rdf = new PdbXmlParser().parse("2W6V");
		System.err.println(rdf.size());
		rdf.write(System.out);
	}
}
