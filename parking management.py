
def calculateBaseFee(hours):
    return hours * 20.0


def calculateVehicleSurcharge(vehicleType, baseFee):
    if vehicleType.lower() == "car":
        rate = 0.20
    elif vehicleType.lower() == "bike":
        rate = 0.10
    elif vehicleType.lower() == "van":
        rate = 0.30
    else:
        rate = 0

    return baseFee + (baseFee * rate)


def calculateTrackingFee(trackingEnabled):
    if trackingEnabled:
        return 50.0
    return 0.0


def totalParkingBill(hours, vehicleType, trackingEnabled):
    baseFee = calculateBaseFee(hours)
    vehicleAmount = calculateVehicleSurcharge(vehicleType, baseFee)
    trackingFee = calculateTrackingFee(trackingEnabled)

    return vehicleAmount + trackingFee


def calculateFinalParkingFee(hours, vehicleType, trackingEnabled):
    total = totalParkingBill(hours, vehicleType, trackingEnabled)

    if hours >= 5:
        total = total - (total * 0.10)

    return total


hours = 5
vehicleType = "car"
trackingEnabled = True

baseFee = calculateBaseFee(hours)
vehicleAmount = calculateVehicleSurcharge(vehicleType, baseFee)
surcharge = vehicleAmount - baseFee
trackingFee = calculateTrackingFee(trackingEnabled)
total = totalParkingBill(hours, vehicleType, trackingEnabled)
discount = total * 0.10 if hours >= 5 else 0
finalFee = calculateFinalParkingFee(hours, vehicleType, trackingEnabled)

print(f"Base fee = {baseFee:.2f}")
print(f"Surcharge = {surcharge:.2f}")
print(f"Tracking fee = {trackingFee:.2f}")
print(f"Total before discount = {total:.2f}")
print(f"Discount = {discount:.2f}")
print(f"Final payable fee = {finalFee:.2f}")
