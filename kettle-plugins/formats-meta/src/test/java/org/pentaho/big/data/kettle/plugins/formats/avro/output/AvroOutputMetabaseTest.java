/*! ******************************************************************************
 *
 * Pentaho Data Integration
 *
 * Copyright (C) 2018 by Hitachi Vantara : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/
package org.pentaho.big.data.kettle.plugins.formats.avro.output;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.pentaho.di.trans.step.StepDataInterface;
import org.pentaho.di.trans.step.StepInterface;
import org.pentaho.di.trans.step.StepMeta;

import static org.mockito.Mockito.spy;

/**
 * Created by rmansoor on 4/8/2018.
 */
@RunWith( MockitoJUnitRunner.class )
public class AvroOutputMetabaseTest {
  private AvroOutputMetaBase metaBase;

  @Before
  public void setUp() throws Exception {
    metaBase = spy( new AvroOutputMetaBase() {
      @Override
      public StepInterface getStep( StepMeta stepMeta, StepDataInterface stepDataInterface, int copyNr,
          TransMeta transMeta,
          Trans trans ) {
        return null;
      }

      @Override public StepDataInterface getStepData() {
        return null;
      }
    } );
  }

  @Test
  public void setCompressionType() {
    metaBase.setCompressionType( "snappy" );
    Assert.assertTrue( metaBase.getCompressionType().equals( AvroOutputMetaBase.CompressionType.SNAPPY.toString() ) );
    metaBase.setCompressionType( "Snappy" );
    Assert.assertTrue( metaBase.getCompressionType().equals( AvroOutputMetaBase.CompressionType.SNAPPY.toString() ) );
    metaBase.setCompressionType( "SNAPPY" );
    Assert.assertTrue( metaBase.getCompressionType().equals( AvroOutputMetaBase.CompressionType.SNAPPY.toString() ) );
    metaBase.setCompressionType( "deflate" );
    Assert.assertTrue( metaBase.getCompressionType().equals( AvroOutputMetaBase.CompressionType.DEFLATE.toString() ) );
    metaBase.setCompressionType( "Deflate" );
    Assert.assertTrue( metaBase.getCompressionType().equals( AvroOutputMetaBase.CompressionType.DEFLATE.toString() ) );
    metaBase.setCompressionType( "DEFLATE" );
    Assert.assertTrue( metaBase.getCompressionType().equals( AvroOutputMetaBase.CompressionType.DEFLATE.toString() ) );
    metaBase.setCompressionType( "DEFLATE124" );
    Assert.assertTrue( metaBase.getCompressionType().equals( AvroOutputMetaBase.CompressionType.NONE.toString() ) );
    metaBase.setCompressionType( "None" );
    Assert.assertTrue( metaBase.getCompressionType().equals( AvroOutputMetaBase.CompressionType.NONE.toString() ) );
    metaBase.setCompressionType( "NONE" );
    Assert.assertTrue( metaBase.getCompressionType().equals( AvroOutputMetaBase.CompressionType.NONE.toString() ) );
  }
}
