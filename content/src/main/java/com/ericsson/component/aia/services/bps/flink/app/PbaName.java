/**
 *
 * (C) Copyright LM Ericsson System Expertise AT/LMI, 2016
 *
 * The copyright to the computer program(s) herein is the property of Ericsson  System Expertise EEI, Sweden.
 * The program(s) may be used and/or copied only with the written permission from Ericsson System Expertise
 * AT/LMI or in  * accordance with the terms and conditions stipulated in the agreement/contract under which
 * the program(s) have been supplied.
 *
 */
package com.ericsson.component.aia.services.bps.flink.app;


import org.apache.avro.generic.GenericRecord;
import org.apache.flink.streaming.api.datastream.DataStream;
import com.ericsson.component.aia.services.bps.core.service.streams.BpsStream;
import com.ericsson.component.aia.services.bps.flink.jobrunner.BpsFlinkStreamingJobRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This class extends {@link BpsFlinkStreamingJobRunner} and provides logic for reading {@link DataStream} from data sources and applying
 * transformation and writing the result to configured data sinks
 */
public class pbaNameInCamelCase extends BpsFlinkStreamingJobRunner{

    private static final long serialVersionUID=5914257776162053344L;

    private static final Logger LOGGER=LoggerFactory.getLogger(pbaNameInCamelCase.class);

    @SuppressWarnings("unchecked")
    @Override
    public void executeJob(){

        /**
         * 1st step: Gets Kafka Stream as defined in flow.xml. e.g,
         *
         *           BpsStream<DataStream<GenericRecord>>flinkStream
         *                    =getBpsInputStreams().<DataStream<GenericRecord>>getStreams("input-stream");
         *           DataStream<GenericRecord>dataStream=flinkStream.getStreamRef();
         *
         * Get the flink DataStream of GenericRecord type
         */

        /**
         * 2nd step: Implment the business logic, like transformation, enrichment etc. e.g,
         *
         *            dataStream.map(new MapFunction<string, GenericRecord>(){
         *
         *               @Override
         *               public String map(GenericRecord record) throws Exception{
         *
         *               }
         *            }
         *
         */

        /*
         * 3rd step: Save output to kakfa, Jdbc use persistDataStream which will write the data on the external source specified
         * in flow.xml. e.g,
         *
         * persistDataStream(dataStream);
         */

    }

    @Override
    public void cleanUp(){
    }
}
