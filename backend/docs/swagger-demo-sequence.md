# Swagger Demo Sequence

Run with the `demo` profile.

```bash
./gradlew bootRun --args='--spring.profiles.active=demo'
```

Swagger:

```text
http://localhost:8080/swagger-ui/index.html
```

## Demo Accounts

Member:

```json
{
  "email": "host@moyeota.test",
  "password": "Password123!"
}
```

Admin:

```json
{
  "loginId": "admin",
  "password": "Password123!"
}
```

Signup verification code:

```text
R8K2Q7
```

## 1. Public And Signup

No token required.

1. `GET /health`
2. `POST /api/members/signup`
3. `POST /api/members/email-verification/request`
4. `POST /api/members/email-verification/confirm`
   - Use `R8K2Q7`.

## 2. Kakao Login

No token required.

1. `POST /api/members/social-login/kakao`
   - Demo profile returns `kakao-rider@moyeota.test` without calling Kakao.
   - Copy `data.accessToken` into Swagger Authorize as `Bearer {token}`.
2. `POST /api/members/logout`
   - This shows the Kakao login/logout success case.

## 3. Normal Member Login

No token required for login.

1. `POST /api/members/login`
   - Use `host@moyeota.test`.
   - Copy `data.accessToken` into Swagger Authorize as `Bearer {token}`.

Keep this normal member token for every non-admin API below.

## 4. Member APIs

1. `GET /api/members/me`
2. `PATCH /api/members/me`
3. `GET /api/members/me/participations`
4. `GET /api/members/me/fundings`
5. `GET /api/members/me/payments`
6. `GET /api/notifications`

## 5. Funding APIs

1. `GET /api/fundings`
2. `GET /api/fundings/1`
3. `GET /api/fundings/price-preview`
4. `POST /api/fundings`
5. `PATCH /api/fundings/4`
6. `DELETE /api/fundings/5`

## 6. Seat, Participation, Payment APIs

1. `GET /api/pathinfos/1/seats`
2. `POST /api/seats/2/hold`
3. `POST /api/participations`
4. `GET /api/participations/me`
5. `DELETE /api/participations/5`
6. `POST /api/payments/prepare?participationId=2`
7. `POST /api/payments/deposit/confirm`
8. `POST /api/payments/prepare?participationId=2`
9. `POST /api/payments/balance/confirm`
10. `POST /api/payments/1/refund`

The `demo` profile skips external Toss calls.

## 7. Chat And Settlement APIs

1. `GET /api/chatrooms/funding/1`
2. `GET /api/chatrooms/1/messages`
3. `GET /api/fundings/1/participations`
4. `POST /api/settlements`
5. `GET /api/settlements/funding/3`

## 8. Admin APIs

Run `POST /api/admin/login`, then replace Swagger Authorize token with the admin access token.

1. `GET /api/admin/members`
2. `GET /api/admin/members/2`
3. `PATCH /api/admin/members/3`
4. `GET /api/admin/fundings`
5. `PATCH /api/admin/fundings/6`
6. `GET /api/admin/settlements`
7. `GET /api/admin/settlements/1`
8. `PATCH /api/admin/settlements/1/approve`
9. `PATCH /api/admin/settlements/2/reject`
10. `GET /api/admin/statistics`
11. `POST /api/admin/payments/retry-refund/1`
12. `POST /api/admin/logout`

## 9. Final Member Withdrawal

Switch Swagger Authorize back to the `host@moyeota.test` member token. Run this last because the admin funding and settlement demo data is owned by this member.

1. `DELETE /api/members/me`
