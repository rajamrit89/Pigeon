/**
 *
 * Copyright © 2014 Florian Schmaus
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jivesoftware.smack.sm;

import org.jivesoftware.smack.SmackException;

public abstract class StreamManagementException extends SmackException {

    public StreamManagementException() {
    }

    public StreamManagementException(String message) {
        super(message);
    }

    /**
     * 
     */
    private static final long serialVersionUID = 3767590115788821101L;

    public static class StreamManagementNotEnabledException extends StreamManagementException {

        /**
         * 
         */
        private static final long serialVersionUID = 2624821584352571307L;

    }

    public static class StreamIdDoesNotMatchException extends StreamManagementException {

        /**
         * 
         */
        private static final long serialVersionUID = 1191073341336559621L;

        public StreamIdDoesNotMatchException(String expected, String got) {
            super("Stream IDs do not match. Expected '" + expected + "', but got '" + got + "'");
        }
    }
}

