package com.kodilla.good.patterns.solid;

public class RentalProcessor {
    private InformationService informationService;
    private RentalService rentalService;
    private RentalRepository rentalRepository;

    public RentalProcessor(final InformationService informationService, final RentalService rentalService, final CarRentalRepository rentalRepository) {
        this.informationService = informationService;
        this.rentalService = rentalService;
        this.rentalRepository = rentalRepository;
    }

    public RentalDto process(final RentRequest rentRequest){
        boolean isRented = rentalService.rent(rentRequest.getUser(), rentRequest.rentFrom, rentRequest.getFrom());
        if(isRented){
            informationService.inform(rentRequest.getUser());
            rentalRepository.createRental(rentRequest.getUser(), rentRequest.getFrom(), rentRequest.rentTo);
            return new RentalDto(rentRequest.getUser(), true);
        }else{
            return new RentalDto(rentRequest.getUser(), false);
        }
    }
}
