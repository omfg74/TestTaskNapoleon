package com.example.omfg.napoleontesttask.Networking.Interfaces;

import java.util.List;

import AppObjects.Banner;

public interface ResponseInterface {
    public List<Banner> createGetBannerResponse();

    public List<AppObjects.Offer> createGetOffersResponse();

}
