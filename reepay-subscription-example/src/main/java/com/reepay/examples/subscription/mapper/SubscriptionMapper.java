package com.reepay.examples.subscription.mapper;

import com.reepay.examples.subscription.model.CustomerDto;
import com.reepay.examples.subscription.model.FormData;
import com.reepay.examples.subscription.model.SubscriptionDto;

/**
 * Created by mikkel on 03/04/2017.
 */
public final class SubscriptionMapper {
    public static SubscriptionDto getSubscription(FormData customer){
        SubscriptionDto subscriptionDTO = new SubscriptionDto();
        CustomerDto customerDto = new CustomerDto();

        customerDto.setEmail(customer.getEmail());

        if(customer.getHandle() != null) {
            customerDto.setHandle(customer.getHandle());
        } else {
            customerDto.setGenerateHandle(true);
        }
        subscriptionDTO.setCustomer(customerDto);

        if(customer.getMethod().equals("card_token")) {
            subscriptionDTO.setCardToken(customer.getToken());
        } else {
            subscriptionDTO.setSignupMethod(customer.getMethod());
        }
        subscriptionDTO.setPlan(customer.getPlan());
        return subscriptionDTO;
    }
}