/**
 * Copyright (C) 2017-Present Pivotal Software, Inc. All rights reserved.
 * <p>
 * This program and the accompanying materials are made available under
 * the terms of the under the Apache License, Version 2.0 (the "License”);
 * you may not use this file except in compliance with the License.
 * <p>
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * <p>
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.pivotal.cf.broker.es;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.service.AbstractServiceConnectorCreator;
import org.springframework.cloud.service.ServiceConnectorConfig;

@Slf4j
public class ElasticSearchConnectionCreator extends AbstractServiceConnectorCreator<ElasticSearchRepository, ElasticSearchServiceInfo> {

    @Override
    public ElasticSearchRepository create(ElasticSearchServiceInfo serviceInfo, ServiceConnectorConfig serviceConnectorConfig) {
        log.info("creating elasticsearch repo wth service info: " + serviceInfo);
        try {
            return new ElasticSearchRepositoryFactory().create(serviceInfo);
        } catch (InterruptedException e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        }
    }
}