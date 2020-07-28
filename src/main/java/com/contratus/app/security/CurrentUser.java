package com.contratus.app.security;

import com.contratus.backend.data.entity.User;

@FunctionalInterface
public interface CurrentUser {

	User getUser();
}
