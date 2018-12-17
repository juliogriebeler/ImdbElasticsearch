package br.com.juliogriebeler.elsearch;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@ComponentScan(basePackages = { "br.com.juliogriebeler.elsearch.title.basic.service" })
@EnableElasticsearchRepositories(basePackages = "br.com.juliogriebeler.elsearch.title.basic.repository")
public class EsConfig {

	@Value("${spring.data.elasticsearch.cluster-name}")
	private String clusterName;
	@Value("${spring.data.elasticsearch.cluster-nodes}")
	private String clusterNodes;

	@Bean
	public Client client() {
		TransportClient client = new TransportClient();
		TransportAddress address = new InetSocketTransportAddress(clusterNodes.split(":")[0], Integer.parseInt(clusterNodes.split(":")[1]));
		client.addTransportAddress(address);
		return client;
	}
	
	@Bean
	public ElasticsearchOperations elasticsearchTemplate() {
		return new ElasticsearchTemplate(client());
	}
}