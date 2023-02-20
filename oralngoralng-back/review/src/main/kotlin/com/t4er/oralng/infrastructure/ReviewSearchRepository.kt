package com.t4er.oralng.infrastructure

import com.t4er.oralng.domain.Review
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface ReviewSearchRepository : ElasticsearchRepository<Review, Long>