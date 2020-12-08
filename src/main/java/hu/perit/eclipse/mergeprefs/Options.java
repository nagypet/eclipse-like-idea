/*******************************************************************************
 * Copyright 2020 Peter Nagy
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/

package hu.perit.eclipse.mergeprefs;

import java.io.File;

import lombok.Getter;

@Getter
public class Options {

	private final String[] args;
	private File targetFolder;

	public Options(String[] args) {
		this.args = args;
	}

	public boolean parse() {
		if (args == null 
				|| args.length == 0 
				|| args.length > 1 
				|| args[0].equals("/?") 
				|| args[0].equals("-?") 
				|| args[0].equals("/h")
				|| args[0].equals("-h") 
				|| args[0].equals("--help")) {
			this.printUsage();
			return false;
		} else {
			this.targetFolder = new File(args[0]);
			return true;
		}
	}

	
	public boolean validate() {
		if (this.targetFolder == null || !this.targetFolder.exists()) {
			System.out.println("Target folder not specified or does not exist!");
			return false;
		}

		System.out.format("Target folder: '%s'%n", this.targetFolder.getAbsolutePath());
		return true;
	}

	
	private void printUsage() {
		System.out.format("Usage: merge-prefs workspace-folder%n" 
				+ "\te.g. merge-prefs c:\\dev\\eclipse-wsp\\myproject%n");
	}
}
