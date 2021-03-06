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

import hu.perit.spvitamin.core.StackTracer;
import lombok.extern.log4j.Log4j;


@Log4j
public class Application
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Options options = new Options(args);
        if (!options.parse())
        {
            return;
        }

        if (!options.validate())
        {
            return;
        }

        try
        {
        	Merger merger = new Merger(new File(System.getProperty("user.dir")), options.getTargetFolder());
        	merger.merge();
        }
        catch (Exception ex)
        {
            log.error(StackTracer.toString(ex));
        }
    }
}
