package io.github.hsyyid.itemauction.events;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.NamedCause;
import org.spongepowered.api.event.impl.AbstractEvent;
import org.spongepowered.api.item.inventory.ItemStack;

public class AuctionEvent extends AbstractEvent implements Cancellable
{
	private boolean cancelled = false;

	private Player sender;
	private double price;
	private ItemStack itemStack;

	public Player getSender()
	{
		return sender;
	}

	public double getPrice()
	{
		return price;
	}

	public ItemStack getItemStack()
	{
		return itemStack;
	}

	public boolean isCancelled()
	{
		return cancelled;
	}

	public void setCancelled(boolean cancel)
	{
		cancelled = cancel;
	}

	public AuctionEvent(Player sender, ItemStack itemStack, double price)
	{
		this.sender = sender;
		this.itemStack = itemStack;
		this.price = price;
	}

	public Cause getCause()
	{
		return Cause.of(NamedCause.source(this.sender));
	}
}
