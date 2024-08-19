/*
 * Copyright 2020-2099 sa-token.cc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.dev33.satoken.oauth2.config;

import cn.dev33.satoken.oauth2.consts.SaOAuth2Consts;
import cn.dev33.satoken.oauth2.function.SaOAuth2ConfirmViewFunction;
import cn.dev33.satoken.oauth2.function.SaOAuth2DoLoginHandleFunction;
import cn.dev33.satoken.oauth2.function.SaOAuth2NotLoginViewFunction;
import cn.dev33.satoken.util.SaResult;

import java.io.Serializable;

/**
 * Sa-Token-OAuth2 配置类 Model
 *
 * @author click33
 * @since 1.19.0
 */
public class SaOAuth2Config implements Serializable {

	private static final long serialVersionUID = -6541180061782004705L;

	/** 是否打开模式：授权码（Authorization Code） */
	public Boolean enableCode = true;

	/** 是否打开模式：隐藏式（Implicit） */
	public Boolean enableImplicit = true;

	/** 是否打开模式：密码式（Password） */
	public Boolean enablePassword = true;

	/** 是否打开模式：凭证式（Client Credentials） */
	public Boolean enableClient = true;

	/** 是否在每次 Refresh-Token 刷新 Access-Token 时，产生一个新的 Refresh-Token */
	public Boolean isNewRefresh = false;
	
	/** Code授权码 保存的时间(单位：秒) 默认五分钟 */
	public long codeTimeout = 60 * 5;

	/** Access-Token 保存的时间(单位：秒) 默认两个小时 */
	public long accessTokenTimeout = 60 * 60 * 2;

	/** Refresh-Token 保存的时间(单位：秒) 默认30 天 */
	public long refreshTokenTimeout = 60 * 60 * 24 * 30;

	/** Client-Token 保存的时间(单位：秒) 默认两个小时 */
	public long clientTokenTimeout = 60 * 60 * 2;

	/** Past-Client-Token 保存的时间(单位：秒) 默认为 -1，代表延续 Client-Token 有效期 */
	public long pastClientTokenTimeout = -1;

	/** 默认 openid 生成算法中使用的摘要前缀 */
	public String openidDigestPrefix = SaOAuth2Consts.OPENID_DEFAULT_DIGEST_PREFIX;



	/**
	 * @return enableCode
	 */
	public Boolean getEnableCode() {
		return enableCode;
	}

	/**
	 * @param enableCode 要设置的 enableCode
	 */
	public void setEnableCode(Boolean enableCode) {
		this.enableCode = enableCode;
	}

	/**
	 * @return enableImplicit
	 */
	public Boolean getEnableImplicit() {
		return enableImplicit;
	}

	/**
	 * @param enableImplicit 要设置的 enableImplicit
	 */
	public void setEnableImplicit(Boolean enableImplicit) {
		this.enableImplicit = enableImplicit;
	}

	/**
	 * @return enablePassword
	 */
	public Boolean getEnablePassword() {
		return enablePassword;
	}

	/**
	 * @param enablePassword 要设置的 enablePassword
	 */
	public void setEnablePassword(Boolean enablePassword) {
		this.enablePassword = enablePassword;
	}

	/**
	 * @return enableClient
	 */
	public Boolean getEnableClient() {
		return enableClient;
	}

	/**
	 * @param enableClient 要设置的 enableClient
	 */
	public void setEnableClient(Boolean enableClient) {
		this.enableClient = enableClient;
	}

	/**
	 * @return isNewRefresh
	 */
	public Boolean getIsNewRefresh() {
		return isNewRefresh;
	}

	/**
	 * @param isNewRefresh 要设置的 isNewRefresh
	 */
	public void setIsNewRefresh(Boolean isNewRefresh) {
		this.isNewRefresh = isNewRefresh;
	}

	/**
	 * @return codeTimeout
	 */
	public long getCodeTimeout() {
		return codeTimeout;
	}

	/**
	 * @param codeTimeout 要设置的 codeTimeout
	 * @return 对象自身
	 */
	public SaOAuth2Config setCodeTimeout(long codeTimeout) {
		this.codeTimeout = codeTimeout;
		return this;
	}

	/**
	 * @return accessTokenTimeout
	 */
	public long getAccessTokenTimeout() {
		return accessTokenTimeout;
	}

	/**
	 * @param accessTokenTimeout 要设置的 accessTokenTimeout
	 * @return 对象自身
	 */
	public SaOAuth2Config setAccessTokenTimeout(long accessTokenTimeout) {
		this.accessTokenTimeout = accessTokenTimeout;
		return this;
	}

	/**
	 * @return refreshTokenTimeout
	 */
	public long getRefreshTokenTimeout() {
		return refreshTokenTimeout;
	}

	/**
	 * @param refreshTokenTimeout 要设置的 refreshTokenTimeout
	 * @return 对象自身
	 */
	public SaOAuth2Config setRefreshTokenTimeout(long refreshTokenTimeout) {
		this.refreshTokenTimeout = refreshTokenTimeout;
		return this;
	}

	/**
	 * @return clientTokenTimeout
	 */
	public long getClientTokenTimeout() {
		return clientTokenTimeout;
	}

	/**
	 * @param clientTokenTimeout 要设置的 clientTokenTimeout
	 * @return 对象自身
	 */
	public SaOAuth2Config setClientTokenTimeout(long clientTokenTimeout) {
		this.clientTokenTimeout = clientTokenTimeout;
		return this;
	}

	/**
	 * @return pastClientTokenTimeout
	 */
	public long getPastClientTokenTimeout() {
		return pastClientTokenTimeout;
	}

	/**
	 * @param pastClientTokenTimeout 要设置的 pastClientTokenTimeout
	 * @return 对象自身
	 */
	public SaOAuth2Config setPastClientTokenTimeout(long pastClientTokenTimeout) {
		this.pastClientTokenTimeout = pastClientTokenTimeout;
		return this;
	}

	/**
	 * @return openidDigestPrefix
	 */
	public String getOpenidDigestPrefix() {
		return openidDigestPrefix;
	}

	/**
	 * @param openidDigestPrefix 要设置的 openidDigestPrefix
	 * @return 对象自身
	 */
	public SaOAuth2Config setOpenidMd5Prefix(String openidDigestPrefix) {
		this.openidDigestPrefix = openidDigestPrefix;
		return this;
	}

	
	// -------------------- SaOAuth2Handle 所有回调函数 -------------------- 
	
	/**
	 * OAuth-Server端：未登录时返回的View 
	 */
	public SaOAuth2NotLoginViewFunction notLoginView = () -> "当前会话在 OAuth-Server 认证中心尚未登录";

	/**
	 * OAuth-Server端：确认授权时返回的View 
	 */
	public SaOAuth2ConfirmViewFunction confirmView = (clientId, scopes) -> "本次操作需要用户授权";

	/**
	 * OAuth-Server端：登录函数 
	 */
	public SaOAuth2DoLoginHandleFunction doLoginHandle = (name, pwd) -> SaResult.error();

	@Override
	public String toString() {
		return "SaOAuth2Config [" +
				"enableCode=" + enableCode
				+ ", enableImplicit=" + enableImplicit
				+ ", enablePassword=" + enablePassword
				+ ", enableClient=" + enableClient
				+ ", isNewRefresh=" + isNewRefresh
				+ ", codeTimeout=" + codeTimeout
				+ ", accessTokenTimeout=" + accessTokenTimeout
				+ ", refreshTokenTimeout=" + refreshTokenTimeout
				+ ", clientTokenTimeout=" + clientTokenTimeout
				+ ", pastClientTokenTimeout=" + pastClientTokenTimeout
				+ ", openidDigestPrefix=" + openidDigestPrefix
				+"]";
	}
	
}
