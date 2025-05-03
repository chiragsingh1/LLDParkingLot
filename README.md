# Parking Lot Management System

A robust object-oriented implementation of a parking lot management system with support for different vehicle types, dynamic pricing, and extensible parking strategies.

## Overview

This system simulates a parking lot with the following features:
- Multiple vehicle type support (Two-Wheeler, Four-Wheeler)
- Automated ticket generation and management
- Configurable parking spot allocation strategies
- Time-based parking fee calculation
- Real-time availability tracking

## Architecture

The application follows SOLID principles and implements several design patterns:
- **Strategy Pattern**: For flexible parking spot allocation algorithms
- **Factory Pattern**: For creating different types of parking spots
- **Singleton Pattern**: For managing system-wide components

## Usage Example

```java
// Create parking spots
TwoWheelerParkingSpot spot1 = new TwoWheelerParkingSpot(20, 1);
FourWheelerParkingSpot spot2 = new FourWheelerParkingSpot(50, 1);

// Initialize the parking manager
ParkingSpotManager spotManager = new ParkingSpotManager(Arrays.asList(spot1, spot2));

// Park a vehicle
Vehicle vehicle = new Vehicle("KA01-1234", VehicleType.TWO_WHEELER);
Ticket ticket = spotManager.findAndBookParkingSpot(vehicle);

// Check availability
spotManager.displayAvailability();

// Unpark the vehicle
spotManager.unparkVehicle(ticket);
```

## Class Structure

- **Entities**: Base classes for core domain objects
  - `Vehicle`, `Ticket`, `ParkingSpot` (interface)
  - `AbstractParkingSpot`: Base class for different parking spot types
  
- **Parking**: Concrete implementations and management
  - `ParkingSpotManager`: Central component for parking operations
  - `DefaultParkingStrategy`: Default implementation for finding spots
  - Vehicle-specific spots: `TwoWheelerParkingSpot`, `FourWheelerParkingSpot`

- **Enums**: Type definitions
  - `VehicleType`: Defines supported vehicle categories

## Future Enhancements

- Payment gateway integration
- Multiple pricing strategies (peak hours, weekends, etc.)
- Reservation system
- Electric vehicle charging support
- Mobile application integration
