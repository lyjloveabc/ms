package com.mmn.ms.prepare;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Created by Mmn on 2019/1/19.
 * To be a happy coder!
 */
public class GuavaCache {
    public static void main(String[] args) {
        /*LoadingCache<Long, UserInfo> cache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .build(
                        new CacheLoader<Long, UserInfo>() {
                            @Override
                            public UserInfo load(Long key) throws Exception {
                                return getUserInfoByUserId(key);
                            }
                        }
                );

        try {
            // 读取缓存
            UserInfo user = cache.get(100001L);

        } catch (ExecutionException e) {
            e.printStackTrace();
            doSomethingForException();
        }
*/
        // 定义缓存
        Cache<Object, Object> cache = CacheBuilder.newBuilder().maximumSize(1000).build();

        try {
            // 用户id
            final Long userId = 100001L;

            UserInfo user = (UserInfo) cache.get(userId, new Callable<UserInfo>() {
                @Override
                public UserInfo call() {
                    return getUserInfoByUserId(userId);
                }
            });

            System.out.println(user);
        } catch (ExecutionException e) {
            doSomethingForException();
        }
    }

    private static UserInfo getUserInfoByUserId(Long id) {
        return UserInfo.builder().id(1L).build();
    }

    private static void doSomethingForException() {
        System.out.println(1);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class UserInfo {
    private Long id;
}
