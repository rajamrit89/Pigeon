/**
 *
 * Copyright 2003-2007 Jive Software.
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

package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.StringUtils;

/**
 * Filters for message packets with a particular thread value.
 *
 * @author Matt Tucker
 */
public class ThreadFilter implements PacketFilter {

    private final String thread;

    /**
     * Creates a new thread filter using the specified thread value.
     *
     * @param thread the thread value to filter for.
     */
    public ThreadFilter(String thread) {
        StringUtils.requireNotNullOrEmpty(thread, "Thread must not be null or empty.");
        this.thread = thread;
    }

    public boolean accept(Stanza packet) {
        return packet instanceof Message && thread.equals(((Message) packet).getThread());
    }
}