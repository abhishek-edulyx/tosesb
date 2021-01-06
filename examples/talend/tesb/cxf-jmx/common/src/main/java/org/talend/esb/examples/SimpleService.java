/*
 * #%L
 * CXF :: Example :: SimpleService :: TESB container
 * %%
 * Copyright (C) 2011-2019 Talend Inc.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

package org.talend.esb.examples;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface SimpleService {

    @WebMethod
    String sayHi(String name);

    @WebMethod
    int doubleIt(int arg);
}