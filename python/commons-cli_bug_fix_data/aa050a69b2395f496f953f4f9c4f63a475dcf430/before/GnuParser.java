/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.cli;

import java.util.ArrayList;
import java.util.List;

/**
 * The class GnuParser provides an implementation of the 
 * {@link Parser#flatten(Options,String[],boolean) flatten} method.
 *
 * @author John Keyes (john at integralsource.com)
 * @see Parser
 * @version $Revision$
 */
public class GnuParser extends Parser {

    /**
     * <p>This flatten method does so using the following rules:
     * <ol>
     *  <li>If an {@link Option} exists for the first character of 
     *  the <code>arguments</code> entry <b>AND</b> an {@link Option} 
     *  does not exist for the whole <code>argument</code> then
     *  add the first character as an option to the processed tokens
     *  list e.g. "-D" and add the rest of the entry to the also.</li>
     *  <li>Otherwise just add the token to the processed tokens list.
     *  </li>
     * </ol>
     * </p>
     *
     * @param options The Options to parse the arguments by.
     * @param arguments The arguments that have to be flattened.
     * @param stopAtNonOption specifies whether to stop 
     * flattening when a non option has been encountered
     * @return a String array of the flattened arguments
     */
    protected String[] flatten(Options options, String[] arguments, boolean stopAtNonOption)
    {
        List tokens = new ArrayList();

        boolean eatTheRest = false;

        for (int i = 0; i < arguments.length; i++)
        {
            String arg = arguments[i];

            if ("--".equals(arg))
            {
                eatTheRest = true;
                tokens.add("--");
            }
            else if ("-".equals(arg))
            {
                tokens.add("-");
            }
            else if (arg.startsWith("-"))
            {
                Option option = options.getOption(arg);

                String head = arg.substring(0, 2); // "--" if --foo, "-f" if -foo
                String tail = arg.substring(2);    // "foo" if -foo, "oo" if -foo

                // this is not an Option
                if (option == null)
                {
                    // handle special properties Option (-Dproperty=value for example)
                    Option specialOption = options.getOption(head);

                    if (specialOption != null)
                    {
                        tokens.add(head); // -D
                        tokens.add(tail); // property=value
                    }
                    else
                    {
                        eatTheRest = stopAtNonOption;
                        tokens.add(arg);
                    }
                }
                else
                {
                    tokens.add(arg);
                }
            }
            else
            {
                tokens.add(arg);
            }

            if (eatTheRest)
            {
                for (i++; i < arguments.length; i++)
                {
                    tokens.add(arguments[i]);
                }
            }
        }

        return (String[]) tokens.toArray(new String[tokens.size()]);
    }
}