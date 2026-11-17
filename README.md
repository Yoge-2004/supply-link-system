# Supply Link System

Supply Link System is a full-stack supply-chain application for managing authentication, products, suppliers, warehouses, shipments, and insurance records.

## Technology Stack

- **Frontend:** Angular 14, TypeScript, RxJS, Bootstrap
- **Backend:** Java 11, Spring Boot 2.7, Spring MVC, Spring Data JPA, Spring Security, JWT
- **Database:** MySQL in runtime configuration; H2 is available for tests
- **Build tools:** npm for the frontend and Maven for the backend

## Project Structure

```text
supply-link-system/
├── client/                              # Angular frontend
│   ├── day_14_15/                       # Earlier standalone validation pages and scripts
│   ├── src/
│   │   ├── app/
│   │   │   ├── auth/                    # Login, logout, user views, and auth services
│   │   │   ├── shared/                  # Shared UI components such as the navbar
│   │   │   ├── supplylink/              # Core supply-chain features
│   │   │   │   ├── components/          # Dashboard, product, supplier, and warehouse views
│   │   │   │   ├── services/            # Supply-chain API integration
│   │   │   │   ├── types/               # Product, supplier, and warehouse models
│   │   │   │   └── *-routing.module.ts  # Feature routing
│   │   │   ├── app-routing.module.ts    # Application-level routes
│   │   │   └── app.module.ts            # Root Angular module
│   │   ├── assets/                      # Static assets
│   │   ├── environments/                # Environment-specific configuration
│   │   └── main.ts                      # Frontend entry point
│   ├── package.json                     # Frontend scripts and dependencies
│   └── angular.json                     # Angular CLI configuration
├── server/                              # Spring Boot backend
│   ├── src/main/java/com/edutech/progressive/
│   │   ├── config/                      # Database and security configuration
│   │   ├── controller/                  # REST API controllers
│   │   ├── dao/                         # DAO interfaces and implementations
│   │   ├── dto/                         # Login request and response objects
│   │   ├── entity/                      # JPA domain entities
│   │   ├── exception/                   # Application-specific exceptions
│   │   ├── jwt/                         # JWT utilities and request filtering
│   │   ├── repository/                  # Spring Data repositories
│   │   ├── service/                     # Service contracts
│   │   ├── service/impl/                # Service implementations
│   │   └── SupplyLinkApplication.java   # Spring Boot entry point
│   ├── src/main/resources/              # Backend application configuration
│   └── pom.xml                          # Maven dependencies and build configuration
├── test/
│   ├── backend_tests/                   # Backend integration and feature tests
│   ├── frontend_tests/                  # Angular and browser-facing tests
│   └── config.js                        # Test configuration
└── LICENSE
```

Generated directories such as `server/target/` are build artifacts and are not part of the application source structure.

## Running the Application

### Backend

```bash
cd server
mvn spring-boot:run
```

### Frontend

```bash
cd client
npm install
npm start
```

The Angular development server is configured to run on port `3000`.

## Testing

Run backend tests with Maven:

```bash
cd server
mvn test
```

Run frontend tests with Angular CLI:

```bash
cd client
npm test
```
