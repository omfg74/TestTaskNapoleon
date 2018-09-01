package com.example.omfg.napoleontesttask.Utils;

import com.example.omfg.napoleontesttask.Networking.Requests.BannerRequst;
import com.example.omfg.napoleontesttask.Networking.Interfaces.ResponseInterface;
import java.util.ArrayList;
import java.util.List;

import AppObjects.Banner;
import AppObjects.Offer;

public class ResponseController implements ResponseInterface {

    @Override
    public List<Banner> createGetBannerResponse() {
        BannerRequst bannerRequst = new BannerRequst();
        List<Banner> banners = new ArrayList<>();
        banners = bannerRequst.getBanners();
        return banners;
    }

    @Override
    public List<Offer> createGetOffersResponse() {
        return null;
    }
}
