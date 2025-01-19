##
Parking Lot
 - Floors, Entry Gates, Exit Gates, Display Board.

### Vehicle
vehicleNumber, vehicleType(enum)

### <ParkingSpot> - Compact, Large, TwoWheeler, Handicapped...
spotId, spotType(enum), available, Vehicle

abstract getCharge();
#### CompactSpot(50), LargeSpot(100), TwoWheelerSpot(25), HandicappedSpot(10), Electric(100)

###  ParkingFloor
floorId (G1, G2, G3... ), List<ParkingSpot>


### ParkingLot
List<ParkingFloor> , List<EntryGate>, List<ExitGate>


### EntryGate
- ParkingLot, DisplayBoard,

entryGate.parkVehicle(vehicle);

### ExitGate
- ParkingLot, DisplayBoard, PaymentProcessor

### DisplayBoard
- ParkingLot

### PaymentProcessor