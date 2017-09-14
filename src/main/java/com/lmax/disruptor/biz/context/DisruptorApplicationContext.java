/*
 * Copyright (c) 2010-2020, vindell (https://github.com/vindell).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.lmax.disruptor.biz.context;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.biz.context.event.DisruptorEventPublisher;
import com.lmax.disruptor.biz.event.DisruptorEvent;
import com.lmax.disruptor.biz.event.translator.DisruptorEventTranslator;
import com.lmax.disruptor.dsl.Disruptor;

public class DisruptorApplicationContext implements ApplicationContextAware, DisruptorEventPublisher, InitializingBean {

	protected ApplicationContext applicationContext;
	
	protected Disruptor<DisruptorEvent> disruptor = null;
	
	protected EventTranslator<DisruptorEvent> eventTranslator = null;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
		if(eventTranslator == null){
			eventTranslator = new DisruptorEventTranslator();
		}
		
	}
	
	@Override
	public void publishEvent(DisruptorEvent event) {
		disruptor.publishEvent(eventTranslator);
		//disruptor.getRingBuffer().tryPublishEvent(eventTranslator);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
}
	

