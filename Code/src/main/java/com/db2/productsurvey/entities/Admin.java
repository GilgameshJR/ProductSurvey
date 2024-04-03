package com.db2.productsurvey.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("yes")
public class Admin extends User {
}