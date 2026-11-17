# Supply Link System

Supply Link System is a full-stack supply-chain management application. It provides authenticated interfaces for managing products, suppliers, warehouses, shipments, and insurance records.

## Features

- User login, logout, and JWT-based authentication
- Product management
- Supplier management
- Warehouse management
- Shipment and insurance domain models
- Angular dashboard and feature views
- Spring Boot REST API backed by MySQL

## Technology Stack

- **Frontend:** Angular 14, TypeScript, RxJS, Bootstrap
- **Backend:** Java 11, Spring Boot 2.7, Spring MVC, Spring Data JPA, Spring Security, JWT
- **Database:** MySQL for runtime; H2 is included for tests
- **Build tools:** npm for the frontend and Maven for the backend

## Prerequisites

Install the following before running the application:

- Java 11
- Maven
- Node.js and npm compatible with Angular 14
- MySQL

Check your local tools with:

```bash
java -version
mvn -version
node --version
npm --version
mysql --version
```

## Configuration

The backend currently reads its database settings from:

```text
server/src/main/resources/application.properties
```

Create a MySQL database named `mydb`, then update the datasource URL, username, and password for your local environment. Do not commit real credentials to the repository. For production, use environment-specific configuration or a secrets manager instead of storing credentials in source control.

The application uses Hibernate's `ddl-auto=update` setting for local development. Review this setting and use a migration-based workflow before deploying to production.

The frontend API configuration is in:

```text
client/src/environments/environment.ts
client/src/environments/environment.development.ts
```

Keep the backend running and make sure the configured API URL points to the backend available on your machine.

## Running the Application

Start the backend first:

```bash
cd server
mvn spring-boot:run
```

In another terminal, install frontend dependencies and start Angular:

```bash
cd client
npm ci
npm start
```

The Angular development server runs on port `3000`. Spring Boot uses its default port unless it is changed in the backend configuration.

Open the frontend at:

```text
http://localhost:3000
```

## Testing

Run backend tests with Maven:

```bash
cd server
mvn test
```

Run frontend unit tests:

```bash
cd client
npm test
```

For a non-interactive Angular test run in CI, use:

```bash
npm test -- --watch=false --browsers=ChromeHeadless
```

The repository also contains additional test assets under `test/backend_tests` and `test/frontend_tests`. Check `test/config.js` and the individual test files for their required runner or environment before executing them separately.

## API Areas

The backend controllers are organized around these areas:

| Area | Controller |
| --- | --- |
| Authentication | `LoginController` |
| Products | `ProductController` |
| Suppliers | `SupplierController` |
| Warehouses | `WarehouseController` |
| Shipments | `ShipmentController` |
| Insurance | `InsuranceController` |

Refer to the controller classes under `server/src/main/java/com/edutech/progressive/controller/` for the current routes, request bodies, and response formats.

## Project Structure

```text
supply-link-system/
├── client/                              # Angular frontend
│   ├── src/app/auth/                    # Authentication views and services
│   ├── src/app/shared/                  # Shared UI components
│   ├── src/app/supplylink/              # Supply-chain features
│   ├── src/environments/                # Frontend environment configuration
│   ├── package.json                     # Frontend scripts and dependencies
│   └── angular.json                     # Angular CLI configuration
├── server/                              # Spring Boot backend
│   ├── src/main/java/com/edutech/progressive/
│   │   ├── config/                      # Database and security configuration
│   │   ├── controller/                  # REST API controllers
│   │   ├── dao/                         # DAO interfaces and implementations
│   │   ├── dto/                         # Request and response objects
│   │   ├── entity/                      # JPA domain entities
│   │   ├── exception/                   # Application-specific exceptions
│   │   ├── jwt/                         # JWT utilities and request filtering
│   │   ├── repository/                  # Spring Data repositories
│   │   └── service/                     # Service contracts and implementations
│   ├── src/main/resources/              # Backend configuration
│   └── pom.xml                          # Maven dependencies and build settings
├── test/                                # Additional backend and frontend tests
└── LICENSE
```

Generated directories such as `server/target/` and frontend build output are build artifacts and are not application source code.

## Troubleshooting

### Cannot connect to MySQL

- Confirm that the MySQL service is running.
- Confirm that the `mydb` database exists.
- Check the datasource URL, username, and password in the backend configuration.
- Make sure the configured MySQL port is available.

### Port already in use

- Stop the process using port `3000` or change the Angular port in `client/package.json`.
- Change the Spring Boot port with `server.port` in the backend configuration if the default port is unavailable.

### Authentication or API requests fail

- Start the backend before using frontend features that call the API.
- Confirm that the frontend environment configuration points to the correct backend URL.
- Check the browser developer console and backend logs for CORS, authentication, or database errors.

## License

See [LICENSE](LICENSE).
