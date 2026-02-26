# Patient Management System - Docker Setup

This project uses Docker and Docker Compose to run the Patient Service application alongside a PostgreSQL database.

## Project Structure

```
patient-management-system/
├── docker-compose.yml       # Orchestrates both services
├── .env                     # Environment variables (credentials)
├── .env.example             # Example environment file
├── init-db.sql              # PostgreSQL initialization script
├── .dockerignore             # Files to exclude from Docker build
└── patient-service/
    ├── Dockerfile           # Multi-stage build for Spring Boot app
    └── src/
        └── main/resources/
            └── application.properties  # App configuration
```

## Services

### 1. patient-service-db (PostgreSQL 16)
- **Container Name:** `patient-service-db`
- **Port:** 5432
- **Database:** patientdb
- **User:** postgres
- **Volume:** `postgres_data` (persistent storage)
- **Health Check:** Enabled

### 2. patient-service (Spring Boot Java 21)
- **Container Name:** `patient-service`
- **Port:** 4000
- **Depends On:** patient-service-db
- **Health Check:** Enabled (Spring Actuator)

## Prerequisites

- Docker (version 20.10+)
- Docker Compose (version 2.0+)
- No need to have Maven or Java installed locally

## Quick Start

### 1. Clone and Navigate
```bash
cd patient-management-system
```

### 2. Configure Environment Variables
The `.env` file contains default credentials. For production, update it:

```bash
# Copy the example
cp .env.example .env

# Edit with your preferred credentials
# DB_PASSWORD, DB_USER, etc.
```

### 3. Build and Run Containers
```bash
# Build and start all services
docker-compose up --build

# Or run in background
docker-compose up -d --build
```

### 4. Verify Services
```bash
# Check container status
docker-compose ps

# View logs
docker-compose logs -f patient-service

# Check database
docker-compose logs -f patient-service-db
```

## Common Commands

### Start Services
```bash
docker-compose up -d
```

### Stop Services
```bash
docker-compose down
```

### Stop and Remove Volumes (WARNING: This deletes database data)
```bash
docker-compose down -v
```

### View Real-time Logs
```bash
# All services
docker-compose logs -f

# Specific service
docker-compose logs -f patient-service
docker-compose logs -f patient-service-db
```

### Connect to PostgreSQL
```bash
# From host machine
psql -h localhost -p 5432 -U postgres -d patientdb

# From Docker container
docker-compose exec patient-service-db psql -U postgres -d patientdb
```

### Access Patient Service
```bash
# Health check endpoint
curl http://localhost:4000/actuator/health

# Example API call (adjust based on your endpoints)
curl http://localhost:4000/api/patients
```

## Configuration

### Environment Variables

Edit `.env` file to customize:

```env
# PostgreSQL
DB_NAME=patientdb              # Database name
DB_USER=postgres               # Database user
DB_PASSWORD=postgres_password_123  # Database password
DB_PORT=5432                   # Database port

# Patient Service
SERVICE_PORT=4000              # Spring Boot port
```

### Spring Boot Properties

Located in `patient-service/src/main/resources/application.properties`:

- `spring.jpa.hibernate.ddl-auto=update` - Auto-creates/updates schema
- `spring.datasource.hikari.maximum-pool-size=10` - Connection pool size
- `logging.level.root=INFO` - Logging level

## Database Initialization

The `init-db.sql` script automatically runs when PostgreSQL starts:

- Creates `patients` table with common fields
- Creates `audit_log` table
- Adds sample data
- Creates indexes for performance

To modify the schema, edit `init-db.sql` before first run, or connect directly to the database.

## Troubleshooting

### Container won't start
```bash
# Check logs
docker-compose logs patient-service

# Check if ports are in use
netstat -ano | findstr :4000
netstat -ano | findstr :5432
```

### Database connection fails
```bash
# Ensure database is healthy
docker-compose exec patient-service-db pg_isready -U postgres

# Check service logs
docker-compose logs patient-service
```

### Reset everything
```bash
# Remove containers, volumes, and networks
docker-compose down -v

# Rebuild from scratch
docker-compose up --build
```

### Modify database after startup
```bash
# Connect to database
docker-compose exec patient-service-db psql -U postgres -d patientdb

# Run SQL commands
postgres=# \dt  -- List tables
postgres=# SELECT * FROM patients;
```

## Security Best Practices

1. **Change default credentials** in production:
   - Update `DB_PASSWORD` in `.env`
   - Use strong passwords

2. **Don't commit `.env`** file to Git:
   - Keep `.env.example` as template
   - Add `.env` to `.gitignore`

3. **Use environment-specific configs**:
   - `docker-compose.prod.yml` for production
   - `docker-compose.dev.yml` for development

4. **Network isolation**:
   - Services communicate via internal Docker network
   - Only necessary ports exposed

## Production Deployment

For production deployments:

```bash
# Use specific image versions
docker pull postgres:16-alpine
docker pull eclipse-temurin:21-jdk-jammy

# Build with optimizations
docker-compose -f docker-compose.yml build --no-cache

# Run with resource limits
docker-compose up -d --compatibility

# Monitor with health checks
docker-compose ps
```

## Cleanup

### Remove stopped containers
```bash
docker container prune
```

### Remove unused images
```bash
docker image prune
```

### Remove all Docker build cache
```bash
docker builder prune
```

## Support & Documentation

- Docker Docs: https://docs.docker.com
- Spring Boot with Docker: https://spring.io/guides/gs/spring-boot-docker
- PostgreSQL Docker: https://hub.docker.com/_/postgres

---

**Last Updated:** February 2026
