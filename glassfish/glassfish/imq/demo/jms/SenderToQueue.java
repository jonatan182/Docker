/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2000-2009 Sun Microsystems, Inc. All rights reserved. 
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License ("CDDL") (collectively, the "License").  You may
 * not use this file except in compliance with the License.  You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or mq/legal/LICENSE.txt.  See the License for the specific language
 * governing permissions and limitations under the License.
 * 
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at mq/legal/LICENSE.txt.  Sun designates
 * this particular file as subject to the "Classpath" exception as provided by
 * Sun in the GPL Version 2 section of the License file that accompanied this
 * code.  If applicable, add the following below the License Header, with the
 * fields enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 * 
 * Contributor(s):
 * 
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or  to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright holder. 
 */

/*
 * @(#)SenderToQueue.java	1.6 07/02/07
 */ 

import javax.jms.*;

/**
 * The SenderToQueue class consists only of a main method, which sends 
 * several messages to a queue.
 * <p>
 * Run this program in conjunction with either SynchQueueExample or 
 * AsynchQueueExample.  Specify a queue name on the command line when you run 
 * the program.  By default, the program sends one message.  Specify a number 
 * after the queue name to send that number of messages.
 */
public class SenderToQueue {

    /**
     * Main method.
     *
     * @param args	the queue used by the example and, optionally, the
     *                   number of messages to send
     */
    public static void main(String[] args) {
        String               queueName = null;
        ConnectionFactory    connectionFactory = null;
        Connection           connection = null;
        Session              session = null;
        Queue                queue = null;
        MessageProducer      msgProducer = null;
        TextMessage          message = null;
        final int            NUM_MSGS;
        final String         MSG_TEXT = new String("Here is a message");
        int                  exitResult = 0;
        
    	if ( (args.length < 1) || (args.length > 2) ) {
    	    System.out.println("Usage: java SenderToQueue <queue_name> [<number_of_messages>]");
    	    System.exit(1);
    	} 
        queueName = new String(args[0]);
        System.out.println("Queue name is " + queueName);
        if (args.length == 2){
            NUM_MSGS = (new Integer(args[1])).intValue();
        } else {
            NUM_MSGS = 1;
        }
    	    
        try {
            connectionFactory = 
                SampleUtilities.getConnectionFactory();
            connection = 
                connectionFactory.createConnection();
            session = connection.createSession(false, 
                Session.AUTO_ACKNOWLEDGE);
            queue = SampleUtilities.getQueue(queueName, session);
    	} catch (Exception e) {
            System.out.println("Connection problem: " + e.toString());
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException ee) {} 
            }
    	    System.exit(1);
    	} 

        /*
         * Create producer.
         * Create text message.
         * Send five messages, varying text slightly.
         * Send end-of-messages message.
         * Finally, close connection.
         */
        try {
            msgProducer = session.createProducer(queue);
            message = session.createTextMessage();
            for (int i = 0; i < NUM_MSGS; i++) {
                message.setText(MSG_TEXT + " " + (i + 1));
                System.out.println("Sending message: " + message.getText());
                msgProducer.send(message);
            }

            // Send a non-text control message indicating end of messages.
            msgProducer.send(session.createMessage());
        } catch (JMSException e) {
            System.out.println("Exception occurred: " + e.toString());
            exitResult = 1;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    exitResult = 1;
                }
            }
        }
    	SampleUtilities.exit(exitResult);
    }
}
