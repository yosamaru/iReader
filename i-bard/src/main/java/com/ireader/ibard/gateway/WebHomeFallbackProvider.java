package com.ireader.ibard.gateway;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

public class WebHomeFallbackProvider implements FallbackProvider {

  @Override
  public String getRoute() {
    return "gangplank";
  }

  /**
   * 请求失败，返回指定信息调用者
   */
  @Override
  public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
    return new ClientHttpResponse() {
      /**
       * 网关向 api 服务请求失败了，但是消费者客户端向网关发起的请求是成功的，
       * 不应该把 api 的 404,500 等问题抛给客户端
       * 网关和 api 服务集群对于客户端来说是黑盒
       * @return
       * @throws IOException
       */
      @Override
      public HttpStatus getStatusCode() throws IOException {
        return HttpStatus.OK;
      }

      @Override
      public int getRawStatusCode() throws IOException {
        return HttpStatus.OK.value();
      }

      @Override
      public String getStatusText() throws IOException {
        return HttpStatus.OK.getReasonPhrase();
      }

      @Override
      public void close() {

      }

      @Override
      public InputStream getBody() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("message", "无法连接，请检查您的网络");
        return new ByteArrayInputStream(objectMapper.writeValueAsString(map).getBytes("UTF-8"));
      }

      @Override
      public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        // 和 getBody 中的内容编码一致
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return headers;
      }
    };
  }
}
