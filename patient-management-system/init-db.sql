-- Initialize the patient database
-- This script runs automatically when the PostgreSQL container starts

-- Create necessary extensions
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

-- Create patients table
CREATE TABLE IF NOT EXISTS patients (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(20),
    date_of_birth DATE,
    gender VARCHAR(10),
    address VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(100),
    postal_code VARCHAR(20),
    country VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create index on email for faster lookups
CREATE INDEX IF NOT EXISTS idx_patients_email ON patients(email);

-- Create audit log table
CREATE TABLE IF NOT EXISTS audit_log (
    id SERIAL PRIMARY KEY,
    entity_type VARCHAR(50) NOT NULL,
    entity_id INTEGER,
    action VARCHAR(20) NOT NULL,
    old_values JSONB,
    new_values JSONB,
    created_by VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert sample data (optional)
INSERT INTO patients (first_name, last_name, email, phone, gender, city, state, country)
VALUES 
    ('John', 'Doe', 'john.doe@example.com', '555-0101', 'Male', 'New York', 'NY', 'USA'),
    ('Jane', 'Smith', 'jane.smith@example.com', '555-0102', 'Female', 'Los Angeles', 'CA', 'USA'),
    ('Robert', 'Johnson', 'robert.johnson@example.com', '555-0103', 'Male', 'Chicago', 'IL', 'USA')
ON CONFLICT (email) DO NOTHING;

-- Grant permissions (optional - for additional users)
-- CREATE USER patient_app_user WITH PASSWORD 'app_password_123';
-- GRANT CONNECT ON DATABASE patientdb TO patient_app_user;
-- GRANT USAGE ON SCHEMA public TO patient_app_user;
-- GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO patient_app_user;
-- GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO patient_app_user;
