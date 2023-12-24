package com.danzielcode.romania_craft.items.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class Racke extends HoeItem {

    public Racke(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {


        Direction facingDirection = pContext.getHorizontalDirection();

        Level pLevel = pContext.getLevel();
        Player player = pContext.getPlayer();
        InteractionHand pHand = pContext.getHand();
        ItemStack itemStack = pContext.getItemInHand();

        BlockHitResult pHitRight = new BlockHitResult(player.getPosition(0), player.getDirection(), pContext.getClickedPos(),false);
        BlockHitResult pHitLeft = new BlockHitResult(player.getPosition(0), player.getDirection(), pContext.getClickedPos(),false);

        switch (facingDirection){
            case WEST, EAST -> {
                pHitRight = new BlockHitResult(player.getPosition(0), player.getDirection(), pContext.getClickedPos().north(),false);
                pHitLeft = new BlockHitResult(player.getPosition(0), player.getDirection(), pContext.getClickedPos().south(),false);
            }
            case NORTH,SOUTH -> {
                pHitRight = new BlockHitResult(player.getPosition(0), player.getDirection(), pContext.getClickedPos().west(),false);
                pHitLeft = new BlockHitResult(player.getPosition(0), player.getDirection(), pContext.getClickedPos().east(),false);
            }
            default -> {}
        }
        super.useOn(new UseOnContext(pLevel,player,pHand,itemStack,pHitRight));
        super.useOn(new UseOnContext(pLevel,player,pHand,itemStack,pHitLeft));


        return super.useOn(pContext);
    }
}
